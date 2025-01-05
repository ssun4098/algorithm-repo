import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n * n];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] tokens = s.split(" ");
            for(int j = 0; j < tokens.length; j++) {
                array[(i * n) + j] = Integer.parseInt(tokens[j]);
            }
        }
        Arrays.sort(array);

        bw.write(String.valueOf(array[n * n - n]));

        br.close();
        bw.close();
    }
}