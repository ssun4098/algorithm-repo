import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        String[] tokens = br.readLine().split(" ");

        int[] array = new int[n];

        for(int i = 0; i < tokens.length; i++) {
            array[i] = Integer.parseInt(tokens[i]);
        }

        int l = 0;
        int r = 1;
        int answer = 0;
        while(l < n - 1) {
            int left = array[l];
            int right = array[r];
            if(left + right == m) {
                answer++;
                l++;
                r = l + 1;
                continue;
            }
            if(r == n - 1) {
                l++;
                r = l + 1;
            } else {
                r++;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}