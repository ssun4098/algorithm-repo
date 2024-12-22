import java.util.*;


class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 순서 저장하는 map
        Map<String, Integer> location = new HashMap<String, Integer>();
        int[][] array = new int[friends.length][friends.length];
        int answer = 0;
        
        for(int i = 0; i < friends.length; i++) {
            location.put(friends[i], i);
        }
        
        for(String token: gifts) {
            String[] tokens = token.split(" ");
            String sender = tokens[0];
            String recevier = tokens[1];
            int senderLocation = location.get(sender);
            int recevierLocation = location.get(recevier);
            
            array[senderLocation][senderLocation]++;
            array[recevierLocation][recevierLocation]--;
            array[senderLocation][recevierLocation]++;
        }
        
        for(int i = 0; i < friends.length; i++) {
            int count = 0;
            for(int j = 0; j < friends.length; j++) {
                if(i == j) {
                    continue;
                }
                int iToJ = array[i][j];
                int jToI = array[j][i];
        
                
                if ((iToJ != 0 || jToI != 0) && iToJ > jToI ) {
                    count++;
                    continue;
                }
                
                if(iToJ < jToI) {
                    continue;
                }
                
                int iCount = array[i][i];
                int jCount = array[j][j];
                if(iCount > jCount && iCount != 0) {
                    count++;
                }
            }
            if(answer < count) {
                answer = count;
            }
        }
        return answer;
    }
}