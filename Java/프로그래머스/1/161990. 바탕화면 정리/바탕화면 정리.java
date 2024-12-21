class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = 51, luy = 51, rdx = -1, rdy = -1;
        
        for(int i = 0; i < wallpaper.length; i++) {
            String s = wallpaper[i];
            int first = s.indexOf("#");
            int last = s.lastIndexOf("#");
            
            if(first != -1 && i < luy) {
                luy = i;
            }
            
            if(first != -1 && first < lux) {
                lux = first;
            }
            if(last != -1 && last >= rdx ) {
                rdx = last;
            }
            if(last != -1 && rdy < i) {
                rdy = i;
            }
        }
        
        int[] answer = {luy, lux, rdy+1, rdx+1};
        return answer;
    }
}