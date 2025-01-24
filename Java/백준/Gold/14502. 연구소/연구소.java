import java.io.*;
import java.util.*;

public class Main {
    private static BufferedWriter bw;
    private static BufferedReader br;
    private static int[][] array;
    private static boolean[][] visit;
    private static List<Node> blanks = new ArrayList<>();
    private static List<Combin> combins = new ArrayList<>();
    private static List<Node> bs = new ArrayList<>();
    private static int max = Integer.MIN_VALUE;
    private static int[] a1 = {0, 0, -1, 1};
    private static int[] a2 = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);
        array = new int[n][m];
        visit = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(String.valueOf(s[j]));
                if(array[i][j] == 0) {
                    blanks.add(new Node(j, i));
                }
                if(array[i][j] != 0) {
                    visit[i][j] = true;
                }
                if(array[i][j] == 2) {
                    bs.add(new Node(j, i));
                }
            }
        }

        createCombin(0, 0, new ArrayList<>());
        for(int  i = 0; i < combins.size(); i++) {
            Combin now = combins.get(i);
            int[][] newArray = new int[array.length][];
            for (int e = 0; e < array.length; e++) {
                newArray[e] = array[e].clone();
            }
            Node first = blanks.get(now.getFirst());
            Node second = blanks.get(now.getSecond());
            Node third = blanks.get(now.getThird());

            newArray[first.getY()][first.getX()] = 1;
            newArray[second.getY()][second.getX()] = 1;
            newArray[third.getY()][third.getX()] = 1;
            for(int j = 0; j < bs.size(); j++) {
                Queue<Node> queue = new ArrayDeque<>();
                queue.add(bs.get(j));
                while(!queue.isEmpty()) {
                    Node b = queue.poll();
                    for(int k = 0 ; k < 4; k++) {
                        int nx = b.getX() + a1[k];
                        int ny = b.getY() + a2[k];
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n && newArray[ny][nx] == 0) {
                            queue.add(new Node(nx, ny));
                            newArray[ny][nx] = 2;
                        }
                    }
                }
            }
            int count = 0;
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(newArray[j][k] == 0) {
                        count++;
                    }
                }
            }
            max = Math.max(count, max);
        }

        bw.write(String.valueOf(max));
        br.close();
        bw.close();
    }

    public static void createCombin(int index, int r, List<Integer> current) {
        if(r == 3) {
            combins.add(new Combin(current.get(0), current.get(1), current.get(2)));
            return;
        }
        if(index == blanks.size()) {
            return;
        }
        current.add(index);
        createCombin(index + 1, r + 1, current);

        current.remove(current.size() - 1);
        createCombin(index + 1, r, current);
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

    public static class Combin {
        private int first;
        private int second;
        private int third;

        public Combin(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }

        public int getThird() {
            return third;
        }
    }
}