import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n1 = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int n2 = Integer.parseInt(br.readLine());
        String s2 = br.readLine();

        Map<Integer, Integer> map = new HashMap<>();
        for(String token: s.split(" ")) {
            int i = Integer.parseInt(token);
            if(!map.containsKey(i)) {
                map.put(i, 1);
                continue;
            }
            map.put(i, map.get(i) + 1);
        }
        int[] result = new int[n2];
        String[] slist = s2.split(" ");
        for(int i = 0; i < slist.length; i++) {
            int a = Integer.parseInt(slist[i]);
            if(map.containsKey(a)) {
                result[i] = map.get(a);
            } else {
                result[i] = 0;
            }
        }
        bw.write(Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        bw.close();
        br.close();
    }
}