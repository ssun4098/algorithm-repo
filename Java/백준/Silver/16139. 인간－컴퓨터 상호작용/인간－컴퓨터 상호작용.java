import java.io.*;
import java.util.*;

public class Main {
    private static BufferedWriter bw;
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int len = s.length();

        // 각 문자에 대한 누적 합 배열 생성
        Map<Character, int[]> prefixSumMap = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            int[] prefixSum = new int[len + 1];
            for (int i = 1; i <= len; i++) {
                prefixSum[i] = prefixSum[i - 1] + (s.charAt(i - 1) == c ? 1 : 0);
            }
            prefixSumMap.put(c, prefixSum);
        }

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split(" ");
            char word = tokens[0].charAt(0);
            int start = Integer.parseInt(tokens[1]);
            int end = Integer.parseInt(tokens[2]);

            if (!prefixSumMap.containsKey(word)) {
                bw.write(0 + "\n");
                continue;
            }

            int[] prefixSum = prefixSumMap.get(word);
            int count = prefixSum[end + 1] - prefixSum[start];
            bw.write(count + "\n");
        }

        bw.close();
        br.close();
    }
}