import java.io.*;
import java.util.*;

public class Main {
    private static BufferedWriter bw;
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        int[][] array = new int[n+1][m+1];
        int[][] preSum = new int[n+1][m+1];

        for(int i = 1; i <= n; i++) {
            String[] ss = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                array[i][j + 1] = Integer.parseInt(ss[j]);
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                preSum[i][j] = array[i][j] + preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1];
            }
        }


        int c = Integer.parseInt(br.readLine());

        for(int i = 0; i < c; i++) {
            String[] xys = br.readLine().split(" ");
            int x1 = Integer.parseInt(xys[1]); // 1
            int y1 = Integer.parseInt(xys[0]); // 1
            int x2 = Integer.parseInt(xys[3]); // 1
            int y2 = Integer.parseInt(xys[2]); // 4

            int result = preSum[y2][x2] + preSum[y1-1][x1-1] - preSum[y1-1][x2] - preSum[y2][x1-1];

            bw.write(String.valueOf(result) + "\n");
        }

        bw.close();
        br.close();
    }
}