import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> counts = new ArrayList<>(map.values());
        counts.sort(Collections.reverseOrder());

        int sum = 0, kind = 0;
        for (int count : counts) {
            sum += count;
            kind++;
            if (sum >= k) {
                return kind;
            }
        }
        return kind;
    }
}