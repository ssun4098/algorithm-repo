import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        Map<String, Integer> locationMap = new HashMap<String, Integer>();
        Map<String, Integer> count = new HashMap<String, Integer>(); // 신고 스택
        Map<String, Set<String>> reportMap = new HashMap<String, Set<String>>();
        int[] answer = new int[id_list.length];
        
        for(int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            locationMap.put(id, i);
            count.put(id, 0);
            reportMap.put(id, new HashSet<String>());
        }
        
        for(String r : report) {
            String[] token = r.split(" ");
            String reporter = token[0];
            String reported = token[1];
            
            Set<String> reportSet = reportMap.get(reported);
            if(!reportSet.add(reporter)) {
                continue;
            }
            count.put(reported, count.get(reported) + 1);
            reportMap.put(reported, reportSet);
        }
        for(String s: count.keySet()) {
            int totalCount = count.get(s);
            if(totalCount >= k) {
                Set<String> reporters =reportMap.get(s);
                for(String reporter: reporters) {
                    int location = locationMap.get(reporter);
                    answer[location]++;
                }
            }
        }
        
        return answer;
    }
}