import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int n;
    static int m;
    static int[] array;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        array = new int[m];
        visit = new boolean[n];
        nAndM(0);
        System.out.println(sb.toString());
    }

    static void nAndM(int number) {
        if(number == m) {
            for(int i = 0; i < array.length; i++) {
                sb.append(array[i]).append(' ');
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                array[number] = i+1;
                nAndM(number+1);
                visit[i] = false;
            }
        }
    }
}