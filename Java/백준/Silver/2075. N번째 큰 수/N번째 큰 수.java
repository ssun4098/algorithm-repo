import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());



        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] tokens = s.split(" ");
            for(int j = 0; j < tokens.length; j++) {
                int now = Integer.parseInt(tokens[j]);
                if(q.size() != n) {
                    q.add(now);
                    continue;
                }
                int a = q.peek();
                if(a < now)  {
                    q.poll();
                    q.add(now);
                }
            }
        }
        bw.write(String.valueOf(q.poll()));

        br.close();
        bw.close();
    }
}