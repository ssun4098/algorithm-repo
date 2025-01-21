import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    private static BufferedWriter bw;
    private static BufferedReader br;
    private static int[][] array;
    private static boolean[][] visit;
    private static Queue<Node> queue = new ArrayDeque<>();
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens = br.readLine().split(" ");
        array = new int[Integer.parseInt(tokens[0])][Integer.parseInt(tokens[1])];
        visit = new boolean[Integer.parseInt(tokens[0])][Integer.parseInt(tokens[1])];

        for(int i = 0; i < array.length; i++) {
            String s = br.readLine();
            for(int j = 0; j < s.length(); j++) {
                array[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        visit[0][0] = true;
        queue.add(new Node(1, 0, 0));
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if(now.getX() == array[0].length - 1 && now.getY() == array.length - 1) {
                min = Math.min(now.getCount(), min);
                continue;
            }

            // 위 확인
            if(now.getY() != 0 && !visit[now.getY() - 1][now.getX()] && array[now.getY() - 1][now.getX()] == 1) {
                visit[now.getY() - 1][now.getX()] = true;
                queue.add(new Node(now.getCount() + 1,  now.getX(), now.getY() - 1));
            }

            // 아래 확인
            if(now.getY() != array.length - 1 && !visit[now.getY() + 1][now.getX()] && array[now.getY() + 1][now.getX()] == 1) {
                visit[now.getY() + 1][now.getX()] = true;
                queue.add(new Node(now.getCount() + 1,  now.getX(), now.getY() + 1));
            }

            // 왼쪽 확인
            if(now.getX() != 0  && !visit[now.getY()][now.getX() - 1] && array[now.getY()][now.getX() - 1] == 1) {
                visit[now.getY()][now.getX() - 1] = true;
                queue.add(new Node(now.getCount()+1, now.getX() - 1, now.getY()));
            }

            // 오른쪽 확인
            if(now.getX() != array[0].length - 1 && !visit[now.getY()][now.getX() + 1] && array[now.getY()][now.getX() + 1] == 1) {
                visit[now.getY()][now.getX() + 1] = true;
                queue.add(new Node(now.getCount() + 1, now.getX() + 1, now.getY()));
            }
        }

        bw.write(String.valueOf(min));
        br.close();
        bw.close();
    }

    public static class Node {
        private int count;
        private int x;
        private int y;

        public Node(int count, int x, int y) {
            this.count = count;
            this.x = x;
            this.y = y;
        }

        public int getCount() {
            return count;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}