import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    private static int n;
    private static int m;
    private static int[] array;
    private static boolean[] visit;
    private static BufferedWriter bw;
    private static BufferedReader br;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens = br.readLine().split(" ");
        n = Integer.parseInt(tokens[0]);
        m = Integer.parseInt(tokens[1]);
        array = new int[m];
        visit = new boolean[n];

        nAndM3(0);
        br.close();
        bw.close();
    }

    private static void nAndM3(int p) throws IOException {
        if(p == m) {
            bw.write(Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(" ")) + "\n");
            return;
        }
        for(int i = 0; i < n; i++) {
            if(p != 0 && array[p-1] > i + 1) {
                continue;
            }
            array[p] = i + 1;
            nAndM3(p+1);
        }
    }
}