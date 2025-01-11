import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 짧은 것이 먼저 온다.
                if(o1.length() != o2.length()) {
                    if(o1.length() > o2.length()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }

                int sum1 = 0;
                int sum2 = 0;

                for(int i = 0; i < o1.length(); i++) {
                    if(o1.charAt(i) >= '0' && o1.charAt(i) <= '9') {
                        sum1 += Integer.parseInt(String.valueOf(o1.charAt(i)));
                    }

                    if(o2.charAt(i) >= '0' && o2.charAt(i) <= '9') {
                        sum2 += Integer.parseInt(String.valueOf(o2.charAt(i)));
                    }
                }
                if(sum1 != sum2) {
                    if(sum1 < sum2) {
                        return -1;
                    } else {
                        return 1;
                    }
                }

                return o1.compareTo(o2);
            }
        });
        for(int i = 0; i < n; i++) {
            queue.add(br.readLine());
        }

        while(!queue.isEmpty()) {
            bw.write(queue.poll() + "\n");
        }

        br.close();
        bw.close();
    }
}