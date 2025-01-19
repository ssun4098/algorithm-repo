import java.io.*;
import java.util.Arrays;

public class Main {
    private static BufferedWriter bw;
    private static BufferedReader br;
    private static int L;
    private static int C;
    private static String[] array;
    private static boolean[] visit;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens = br.readLine().split(" ");
        L = Integer.parseInt(tokens[0]);
        C = Integer.parseInt(tokens[1]);
        array = br.readLine().split(" ");
        Arrays.sort(array);
        visit = new boolean[C];
        create(0, 0, 0);
        br.close();
        bw.close();
    }

    private static void create(int p, int count1, int count2) throws IOException {
        if(p >= L && count1 >= 1 && count2 >= 2) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < C; i++) {
                if(visit[i]) {
                    sb.append(array[i]);
                }
            }
            if(sb.length() == L) {
                bw.write(sb + "\n");
            }
        }
        for(int i = p; i < C; i++) {
            if(visit[i]) {
                continue;
            }
            visit[i] = true;
            if(array[i].equals("a") || array[i].equals("e") || array[i].equals("i") || array[i].equals("o") || array[i].equals("u")) {
                create(i+1, count1+1, count2);
            } else {
                create(i+1, count1, count2+1);
            }
            visit[i] = false;
        }
    }
}