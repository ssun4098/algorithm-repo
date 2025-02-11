import java.io.*;
import java.util.*;

public class Main {
    private static BufferedWriter bw;
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);  // 배열 크기
        int m = Integer.parseInt(tokens[1]);  // 질의 개수

        int[][] array = new int[n + 1][n + 1];
        int[][] prefixSum = new int[n + 1][n + 1];

        // 1. 배열 입력 받기
        for (int i = 1; i <= n; i++) {
            String[] numbers = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                array[i][j] = Integer.parseInt(numbers[j - 1]);
            }
        }

        // 2. 2차원 누적합(prefixSum) 계산
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = array[i][j]
                        + prefixSum[i - 1][j]
                        + prefixSum[i][j - 1]
                        - prefixSum[i - 1][j - 1];
            }
        }

        // 3. 각 질의에 대해 부분합 구하기
        for (int i = 0; i < m; i++) {
            String[] xys = br.readLine().split(" ");
            int x1 = Integer.parseInt(xys[0]);
            int y1 = Integer.parseInt(xys[1]);
            int x2 = Integer.parseInt(xys[2]);
            int y2 = Integer.parseInt(xys[3]);

            // 부분합 공식 적용
            int result = prefixSum[x2][y2]
                    - prefixSum[x1 - 1][y2]
                    - prefixSum[x2][y1 - 1]
                    + prefixSum[x1 - 1][y1 - 1];

            bw.write(result + "\n");
        }

        bw.close();
        br.close();
    }
}
