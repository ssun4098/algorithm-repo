import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[] visit;
    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br = new BufferedReader(new InputStreamReader(System.in));
        String doc = br.readLine();
        String patternToken = br.readLine();


        visit = new boolean[doc.length()];
        Pattern pattern = Pattern.compile(patternToken);
        Matcher matcher = pattern.matcher(doc);
        int answer = 0;

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end() - 1;
            boolean flag = true;
            for(int i = start; i <= end; i++) {
                if(visit[i]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                answer++;
                for(int i = start; i <= end; i++) {
                    visit[i] = true;
                }
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }

}
