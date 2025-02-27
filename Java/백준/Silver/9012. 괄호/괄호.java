import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Character> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            deque.clear();
            deque.add(s.charAt(0));
            for(int j = 1; j < s.length(); j++) {
                char now = s.charAt(j);
                if(deque.isEmpty() || now == '(') {
                    deque.add(now);
                    continue;
                }
                char before = deque.peekLast();
                if(before == '(' && now == ')') {
                    deque.pollLast();
                    continue;
                }
                break;
            }
            if(deque.isEmpty()) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        bw.close();
        br.close();
    }
}