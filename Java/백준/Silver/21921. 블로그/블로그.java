import java.io.*;
import java.util.*;

public class Main {
    private static BufferedWriter bw;
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br = new BufferedReader(new InputStreamReader(System.in));

        String[] nx = br.readLine().split(" ");
        int n = Integer.parseInt(nx[0]);
        int x = Integer.parseInt(nx[1]);

        int[] array = new int[n + 1];

        String[] s = br.readLine().split(" ");

        for(int i = 0; i < n; i++) {
            array[i + 1] = Integer.parseInt(s[i]) + array[i];
        }

        int count = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i <= n - x; i++) {
            int value = array[i + x] - array[i];
            if(value == 0) {
                continue;
            }

            if(value > max) {
                max = value;
                count = 1;
                continue;
            }
            if(value == max) {
                count++;
            }
        }


        if(count == 0) {
            bw.write("SAD");
        } else {
            bw.write(max + "\n" + count);
        }

        bw.close();
        br.close();
    }
}
