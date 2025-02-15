import java.io.*;
import java.util.*;

public class Main {
    private static BufferedWriter bw;
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] tokens = br.readLine().split(" ");
        int[] array = new int[n+1];
        int[] preSumArray = new int[n+1];
        array[n] = Integer.parseInt(tokens[n - 1]);
        for(int i = n - 1; i > 0; i--) {
            array[i] = Integer.parseInt(tokens[i - 1]);
        }

        for(int i = 1; i < n ; i++) {
            preSumArray[i] = array[i] > array[i + 1] ? preSumArray[i - 1] + 1 : preSumArray[i - 1];
        }
        preSumArray[n] = preSumArray[n-1];

        int count = Integer.parseInt(br.readLine());
        for(int i = 0; i < count; i++) {
            String[] xy = br.readLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);

            bw.write(preSumArray[y - 1] - preSumArray[x - 1] + "\n");
        }


        bw.close();
        br.close();
    }
}