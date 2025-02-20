import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Set<String> wantSet = new HashSet<>();
        Map<String, Integer> countMap = new HashMap<>();

        for(int i = 0; i < want.length; i++) {
            wantSet.add(want[i]);
        }

        for(int i = 0; i < discount.length; i++) {
            String now = discount[i];
            if(wantSet.contains(now)) {
                countMap.put(now, countMap.getOrDefault(now, 0) + 1);
            }
            if(i < 9) {
                continue;
            }
            if(checkCount(want, number, countMap)) {
                answer++;
            }
            String before = discount[i - 9];
            if(countMap.containsKey(before)) {
                countMap.put(before, countMap.get(before) - 1);
            }
        }

        return answer;
    }

    public static boolean checkCount(String[] want, int[] number, Map<String, Integer> countMap) {
        for(int i = 0; i < want.length; i++) {
            int count = countMap.getOrDefault(want[i], 0);
            if(count < number[i]) {
                return false;
            }
        }
        return true;
    }
}