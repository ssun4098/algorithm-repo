import java.io.*;

public class Main {
    private static BufferedWriter bw;
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] tokens = br.readLine().split(" ");

        int[] array = new int[n + 1];
        int[] preSumArray = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(tokens[i-1]);
            preSumArray[i] = preSumArray[i-1] + array[i];
        }


        int max = 0;

        // case1
        for(int i = 2; i <= n - 1; i++) {
            int first = preSumArray[n] - array[1] - array[i];
            int second = preSumArray[n] - preSumArray[i];
            max = Math.max(max, first + second);
        }

        // case2
        for(int i = 2; i <= n - 1; i++) {
            int first = preSumArray[i] - array[1];
            int second = preSumArray[n - 1] - preSumArray[i - 1];
            max = Math.max(max, first + second);
        }

        // case3
        for(int i = n - 1; i > 0; i--) {
            int first = preSumArray[n - 1] - array[i];
            int second = preSumArray[i - 1];
            max = Math.max(max, first + second);
        }

        bw.write(max + "");

        bw.close();
        br.close();
    }
}