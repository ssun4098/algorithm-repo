import java.io.*;
import java.util.*;

public class Main {
    private static int answer = Integer.MAX_VALUE;
    private static int n;
    private static int[][] array;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        array = new int[n][n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        findTeam(0, 0);
        System.out.println(answer);
    }

    private static void findTeam(int index, int count) {
        if (count == n / 2) {
            calculateDifference();
            return;
        }

        for (int i = index; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                findTeam(i + 1, count + 1);
                visit[i] = false;
            }
        }
    }

    private static void calculateDifference() {
        int startSum = 0, linkSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i] && visit[j]) {
                    startSum += array[i][j];
                } else if (!visit[i] && !visit[j]) {
                    linkSum += array[i][j];
                }
            }
        }

        answer = Math.min(answer, Math.abs(startSum - linkSum));
    }
}
