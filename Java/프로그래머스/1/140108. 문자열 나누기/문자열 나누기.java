class Solution {
    public int solution(String s) {
        int answer = 0;
        
        if(s.length() == 2) {
            return 1;
        }
        
        char c = s.charAt(0);
        int eq = 1;
        int ueq = 0;
        for(int i = 1; i < s.length(); i++) {
            char now = s.charAt(i);
            if(eq == 0) {
                c = now;
                eq = 1;
                continue;
            }
            if( c == now ) {
                eq++;
                continue;
            }
            ueq++;
            if(eq == ueq) {
                answer++;
                eq = 0;
                ueq = 0;
            }
        }
        if(eq != ueq) {
            answer++;
        }
        
        return answer;
    }
}