import java.io.*;

public class Main {
    private static int N;
    private static int L;
    private static int R;
    private static int X;
    private static int answer = 0;
    private static int[] array;
    private static boolean[] visit;
    private static BufferedWriter bw;
    private static BufferedReader br;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens = br.readLine().split(" ");
        N = Integer.parseInt(tokens[0]);
        L = Integer.parseInt(tokens[1]);
        R = Integer.parseInt(tokens[2]);
        X = Integer.parseInt(tokens[3]);

        array = new int[N];
        visit = new boolean[N];

        String[] s = br.readLine().split(" ");
        for(int i = 0; i < s.length; i++ ) {
            array[i] = Integer.parseInt(s[i]);
        }

        camp(0, 0);
        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }

    private static void camp(int start, int p) {
        if(p >= 2) {
            if(compare()) {
                answer++;
            }
        }
        for(int i = start; i < N; i++) {
            if(visit[i]) {
                continue;
            }
            visit[i] = true;
            camp(i+1, p+1);
            visit[i] = false;
        }
    }

    private static boolean compare() {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            if(visit[i]) {
                sum += array[i];
                min = Math.min(array[i], min);
                max = Math.max(array[i], max);
            }
        }
        if(sum < L || sum > R) {
            return false;
        }
        return max - min >= X;
    }
}