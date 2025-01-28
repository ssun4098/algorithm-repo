import java.io.*;

public class Main {
    private static BufferedWriter bw;
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        long[] array = new long[n];
        String[] ss = br.readLine().split(" ");

        for(int i = 0; i < n; i++) {
            array[i] = Long.parseLong(ss[i]);
        }
        long answer = Long.MIN_VALUE;

        for(int i = 0; i <= n - m; i++) {
            long sum = 0;
            for(int j = i; j < i + m; j++) {
                sum += array[j];
            }
            answer = Math.max(answer, sum);
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}
