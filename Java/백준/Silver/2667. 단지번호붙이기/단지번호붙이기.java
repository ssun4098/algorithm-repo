import java.io.*;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    private static BufferedWriter bw;
    private static BufferedReader br;
    private static int[][] array;
    private static boolean[][] visit;
    private static Queue<Integer> answers = new PriorityQueue<>();
    private static Queue<Node> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        array = new int[n][n];
        visit = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String tokens = br.readLine();
            for(int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(String.valueOf(tokens.charAt(j)));
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(array[i][j] == 1 && !visit[i][j]) {
                    queue.add(new Node(j, i));
                    visit[i][j] = true;
                    int count = 0;
                    while(!queue.isEmpty()) {
                        Node now = queue.poll();
                        count++;
                        // 위 확인
                        if(now.getY() != 0 && !visit[now.getY() - 1][now.getX()] && array[now.getY() - 1][now.getX()] == 1) {
                            visit[now.getY() - 1][now.getX()] = true;
                            queue.add(new Node(now.getX(), now.getY() - 1));
                        }

                        // 아래 확인
                        if(now.getY() != n - 1 && !visit[now.getY() + 1][now.getX()] && array[now.getY() + 1][now.getX()] == 1) {
                            visit[now.getY() + 1][now.getX()] = true;
                            queue.add(new Node(now.getX(), now.getY() + 1));
                        }

                        // 왼쪽 확인
                        if(now.getX() != 0 && !visit[now.getY()][now.getX() - 1] && array[now.getY()][now.getX() - 1] == 1) {
                            visit[now.getY()][now.getX() - 1] = true;
                            queue.add(new Node( now.getX() - 1, now.getY()));
                        }

                        // 오른쪽 확인
                        if(now.getX() != n - 1 && !visit[now.getY()][now.getX() + 1] && array[now.getY()][now.getX() + 1] == 1) {
                            visit[now.getY()][now.getX() + 1] = true;
                            queue.add(new Node(now.getX() + 1, now.getY()));
                        }

                        if(queue.isEmpty()) {
                            answers.add(count);
                        }
                    }
                }
            }
        }
        bw.write(answers.size() + "\n");
        while(!answers.isEmpty()) {
            bw.write(String.valueOf(answers.poll()) + "\n");
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