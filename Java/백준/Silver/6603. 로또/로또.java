import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static BufferedWriter bw;
    public static BufferedReader br;
    public static boolean[] visit;
    public static List<String> list = new ArrayList<>();
    public static boolean firstCase = true; // 첫 번째 케이스 여부 확인

    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String[] s = br.readLine().split(" ");
            if(s[0].equals("0")) {
                break;
            }

            if (!firstCase) {
                bw.write("\n"); // 첫 번째가 아닐 경우 줄바꿈 추가
            }
            firstCase = false;

            visit = new boolean[Integer.parseInt(s[0]) + 1];
            func(1, s);
        }
        bw.close();
        br.close();
    }

    public static void func(int now, String[] ss) throws IOException {
        if(list.size() == 6) {
            bw.write(list.stream().collect(Collectors.joining(" ")) + "\n");
            return;
        }
        for(int i = now; i < ss.length; i++) {
            if(visit[i]) {
                return;
            }
            visit[i] = true;
            list.add(ss[i]);
            func(i+1, ss);
            visit[i] = false;
            list.remove(list.size() - 1);
        }
    }
}