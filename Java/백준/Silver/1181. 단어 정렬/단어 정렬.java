import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static BufferedWriter bw;
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        // Java 8 호환 방식으로 수정
        List<String> list = new ArrayList<>(set.stream().collect(Collectors.toList()));

        list.sort((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return Integer.compare(o1.length(), o2.length());
            }
            return o1.compareTo(o2);
        });

        for (String str : list) {
            bw.write(str);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
