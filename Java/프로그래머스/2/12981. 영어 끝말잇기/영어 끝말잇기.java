import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int a = 0;
        int b = 0;
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        for(int i = 1; i < words.length; i++) {
            String now = words[i];
            if(set.contains(now)) {
                a = i  / n + 1;
                b = (i % n) + 1;
                break;
            }
            set.add(now);
            String before = words[i - 1];
            char start = now.charAt(0);
            char end = before.charAt(before.length() - 1);
            if(start != end) {
                a = i  / n + 1;
                b = (i % n) + 1;
                break;
            }
        }
        
        int[] answer = {b, a};
        return answer;
    }
}