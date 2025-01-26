import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static BufferedWriter bw;
    private static BufferedReader br;
    private static int maxCount = 0;
    private static int min = 101;
    private static int max = 0;
    private static int[][] array;
    private static boolean[][] visit;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        array = new int[n][n];
        visit = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(tokens[j]);
                min = Math.min(min, array[i][j]);
                max = Math.max(max, array[i][j]);
            }
        }

        for(int i = 0; i <= max; i++) {
            int[][] newArray = new int[n][n];
            boolean[][] newVisit = new boolean[n][n];

            for(int j = 0; j < n; j++) {
                System.arraycopy(array[j], 0, newArray[j], 0, n);
            }
            int count = 0;
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    if(!newVisit[j][k] && newArray[j][k] > i) {
                        count++;
                        Queue<Node> queue = new ArrayDeque<>();
                        queue.add(new Node(k, j));
                        newVisit[j][k] = true;
                        while(!queue.isEmpty()) {
                            Node now = queue.poll();
                            for(int a = 0; a < 4; a++) {
                                int nx = now.getX() + dx[a];
                                int ny = now.getY() + dy[a];
                                if (nx >= 0 && nx < n && ny >= 0 && ny < n && array[ny][nx] > i && !newVisit[ny][nx]) {
                                    queue.add(new Node(nx, ny));
                                    newVisit[ny][nx] = true;
                                }
                            }
                        }
                        maxCount = Math.max(maxCount, count);
                    }
                }
            }
        }
        bw.write(String.valueOf(maxCount));
        br.close();
        bw.close();
    }

    private static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
