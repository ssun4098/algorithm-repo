class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] scores = {0, 3, 2, 1, 0, 1, 2, 3};
        int[] array = new int [26];
        String answer = "";
        
        for(int i = 0; i < survey.length; i++) {
            int choice = choices[i];
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            if(choice > 4) {
                array[second - 'A'] += scores[choice];
            } else {
                array[first - 'A'] += scores[choice];
            }
        }
        int r = array['R'-'A'];
        int t = array['T'-'A'];
        
        if(r < t) {
            answer += "T";
        } else {
            answer += "R";
        }
        
        int c = array['C'-'A'];
        int f = array['F'-'A'];
        if(c < f) {
            answer += "F";
        } else {
            answer += "C";
        }
        
        
        int j = array['J'-'A'];
        int m = array['M'-'A'];
        if(j < m) {
            answer += "M";
        } else {
            answer += "J";
        }
        
        int a = array['A'-'A'];
        int n = array['N'-'A'];
        if(a < n) {
            answer += "N";
        } else {
            answer += "A";
        }
        
        return answer;
    }
}