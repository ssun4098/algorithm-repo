import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> location = new HashMap<>();
        Map<Integer, String> location2 = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            location.put(players[i], i);
            location2.put(i, players[i]);
        }
        
        for(String calling: callings) {
            int now = location.get(calling);
            String s = location2.get(now-1);
            location.put(calling, now-1);
            location.put(s, now);
            
            location2.put(now-1, calling);
            location2.put(now, s);
        }
        
        String[] answer = new String[players.length];
        
        for(int i = 0; i < players.length; i++) {
            answer[i] = location2.get(i);
        }
        return answer;
    }
}