import java.io.*;
import java.util.Arrays;

public class Main {
    private static BufferedWriter bw;
    private static BufferedReader br;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] array = new int[n][3];
        
        array[0][0] = 1;
        array[0][1] = 1;
        array[0][2] = 1;

        for(int i = 1; i < n; i++) {
            array[i][0] = (array[i-1][0] + array[i-1][1] + array[i-1][2]) % 9901;
            array[i][1] = (array[i-1][0] + array[i-1][2]) % 9901;
            array[i][2] = (array[i-1][0] + array[i-1][1]) % 9901;
        }
        bw.write(String.valueOf((array[n-1][0] + array[n-1][1] + array[n-1][2]) % 9901));

        br.close();
        bw.close();
    }
}