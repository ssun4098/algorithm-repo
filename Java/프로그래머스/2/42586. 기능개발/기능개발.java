import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> beforeMap = new HashMap<>();
        
        for(int i = 0; i < progresses.length; i++) {
            int n = 100 - progresses[i];
            
            int a = n / speeds[i];
            int b = n % speeds[i];
            if(b != 0) {
                a++;
            }
            beforeMap.put(i, a);
            if(i > 0) {
                int beforeDay = beforeMap.get(i-1);
                if(beforeDay >= a) {
                    int count = map.getOrDefault(beforeDay, 0);
                    beforeMap.put(i, beforeDay);
                    map.put(beforeDay, count+1);
                } else {
                    int count = map.getOrDefault(a, 0);
                    map.put(a, count+1);
                }
            } else {
                int count = map.getOrDefault(a, 0);
                map.put(a, count+1);
            }
        }
        
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
    
        int[] answer = new int[keys.size()];
        for(int i = 0; i < keys.size(); i++) {
            answer[i] = map.get(keys.get(i));
        }
        return answer;
    }
}