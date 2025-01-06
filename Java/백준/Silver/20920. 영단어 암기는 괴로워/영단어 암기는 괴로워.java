import java.io.*;
import java.util.*;

class Work {
    private int count = 1;
    private String word;

    public Work(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public String getWord() {
        return word;
    }

    public void upCount() {
        count++;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Work> map = new HashMap<>();
        PriorityQueue<Work> q = new PriorityQueue<>(new Comparator<Work>() {
            @Override
            public int compare(Work o1, Work o2) {
                if (o1.getCount() != o2.getCount()) {
                    return o2.getCount() - o1.getCount(); // count가 많은 순서대로 정렬
                }
                if (o1.getWord().length() != o2.getWord().length()) {
                    return o2.getWord().length() - o1.getWord().length(); // 길이가 긴 순서대로 정렬
                }
                return o1.getWord().compareTo(o2.getWord()); // 알파벳 순서대로 정렬
            }
        });

        String[] token = br.readLine().split(" ");
        int n = Integer.parseInt(token[0]);
        int m = Integer.parseInt(token[1]);

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.length() < m) {
                continue;
            }

            if (!map.containsKey(s)) {
                map.put(s, new Work(s)); // 새로운 단어 추가
            } else {
                map.get(s).upCount(); // 기존 단어의 count 증가
            }
        }

        q.addAll(map.values()); // 모든 값을 우선순위 큐에 추가

        while (!q.isEmpty()) {
            Work w = q.poll(); // 우선순위 큐에서 꺼내기
            bw.write(w.getWord() + "\n");
        }

        br.close();
        bw.close();
    }
}