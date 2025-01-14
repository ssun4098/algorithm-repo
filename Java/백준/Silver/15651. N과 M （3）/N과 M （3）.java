import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int n, m;
    static boolean[] visit;
    static int[] array;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        visit = new boolean[m+1];
        array = new int[m+1];
        function(1);
        System.out.println(sb.toString());
    }

    static void function(int now) {
        if(now > m) {
            for(int i = 1; i <= m; i++) {
                sb.append(array[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < n; i++) {
                array[now] = i+1;
                function(now+1);
        }
    }
}