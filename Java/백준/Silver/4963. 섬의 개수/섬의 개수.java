import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    private static BufferedWriter bw;
    private static BufferedReader br;
    private static int[][] array;
    private static boolean[][] visit;
    private static Queue<Node> queue = new ArrayDeque<>();
    private static final int[] dx = {0, 0, -1, 1, -1, -1, 1, 1}; // 좌, 우, 상, 하, 좌상, 우상, 좌하, 우하
    private static final int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1}; // 좌, 우, 상, 하, 좌상, 우상, 좌하, 우하

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            int count = 0;
            String[] tokens = br.readLine().split(" ");
            int m = Integer.parseInt(tokens[0]);
            int n = Integer.parseInt(tokens[1]);

            if(m == 0 && n == 0) {
                break;
            }

            array = new int[n][m];
            visit = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                tokens = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    array[i][j] = Integer.parseInt(tokens[j]);
                }
            }

            for(int i = 0 ; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(array[i][j] == 1 && !visit[i][j]) {
                        count++;
                        queue.add(new Node(j, i));
                        visit[i][j] = true;
                        while (!queue.isEmpty()) {
                            Node now = queue.poll();
                            for (int k = 0; k < 8; k++) {
                                int nx = now.getX() + dx[k];
                                int ny = now.getY() + dy[k];
                                if (nx >= 0 && nx < m && ny >= 0 && ny < n && array[ny][nx] == 1 && !visit[ny][nx]) {
                                    queue.add(new Node(nx, ny));
                                    visit[ny][nx] = true;
                                }
                            }
                        }
                    }
                }
            }

            bw.write(String.valueOf(count) + "\n");
        }

        br.close();
        bw.close();
    }

    public static class Node {
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