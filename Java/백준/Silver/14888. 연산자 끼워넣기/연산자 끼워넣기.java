import java.io.*;

public class Main {
    private static BufferedWriter bw;
    private static BufferedReader br;
    private static int N;
    private static int[] array;
    private static int[] operators = new int[4];
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        array = new int[N];

        String[] s1 = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(s1[i]);
        }

        String[] s2 = br.readLine().split(" ");
        for(int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(s2[i]);
        }

        cal(1, array[0]);
        bw.write(max + "\n");
        bw.write(min + "\n");
        br.close();
        bw.close();
    }

    private static void cal(int p, int sum) {
        if(p == N) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }
            int a = array[p];
            if(operators[0] > 0) {
                operators[0]--;
                cal(p+1, sum + a);
                operators[0]++;
            }

            if(operators[1] > 0) {
                operators[1]--;
                cal(p+1, sum - a);
                operators[1]++;
            }

            if(operators[2] > 0) {
                operators[2]--;
                cal(p+1, sum * a);
                operators[2]++;
            }

            if(operators[3] > 0) {
                operators[3]--;
                int result = 0;
                if(sum < 0) {
                    result = (Math.abs(sum) / a) * -1;
                } else {
                    result = sum / a;
                }
                cal(p+1, result);
                operators[3]++;
            }
        }
}