import java.io.*;

public class Main {
    private static BufferedWriter bw;
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] ss = br.readLine().split(" ");

        int[] array = new int[n+1];
        for(int i = 1; i <= n; i++) {
            array[i] = array[i-1] + Integer.parseInt(ss[i - 1]);
        }

        int c = Integer.parseInt(br.readLine());
        for(int i = 0; i < c; i++) {
            String[] tokens = br.readLine().split(" ");
            int start = Integer.parseInt(tokens[0]);
            int end = Integer.parseInt(tokens[1]);
            bw.write(array[end] - array[start - 1] + "\n");
        }

        bw.close();
        br.close();
    }
}