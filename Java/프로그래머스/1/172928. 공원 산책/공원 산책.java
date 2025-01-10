class Solution {
    public int[] solution(String[] park, String[] routes) {
        int h = 0;
        int w = 0;
        for(int i = 0; i < park.length; i++) {
            String p = park[i];
            for(int j = 0; j < p.length(); j++) {
                if(p.charAt(j) == 'S') {
                    h = i;
                    w = j;
                }
            }
        }

        
        for(String route: routes) {
            String[] tokens = route.split(" ");
            int n = Integer.parseInt(tokens[1]);
            if(tokens[0].equals("S")) {
                if(h + n  >= park.length) {
                    continue;
                }
                boolean flag = true;
                for(int i = 1; i <= n; i++) {
                    if(park[h + i].charAt(w) == 'X') {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    h = h + n;
                }
            }
            
            if(tokens[0].equals("N")) {
                if(h - n < 0) {
                    continue;
                }
                boolean flag = true;
                for(int i = 1; i <= n; i++) {
                    if(park[h - i].charAt(w) == 'X') {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    h = h - n;
                }
            }
            
            if(tokens[0].equals("E")) {
                int l = park[h].length();
                if(w + n >= l) {
                    continue;
                }
                boolean flag = true;
                String p = park[h];
                for(int i = 1; i <= n; i++) {
                    if(p.charAt(w + i) == 'X') {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    w = w + n;
                }
            }
            
            if(tokens[0].equals("W")) {
                if(w - n < 0) {
                    continue;
                }
                boolean flag = true;
                String p = park[h];
                for(int i = 1; i <= n; i++) {
                    if(p.charAt(w - i) == 'X') {
                        flag = false;
                        break;
                    }
                }
                
                if(flag) {
                    w = w - n;
                }
            }
        }
        
        
        int[] answer = {h, w};
        return answer;
    }
}