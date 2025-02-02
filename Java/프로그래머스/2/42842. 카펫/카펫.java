class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        if(yellow == 1) {
            answer[0] = answer [1] = (int) Math.sqrt(brown + yellow);
            return answer;
        }

        for(int i = 0; i <= Math.sqrt(yellow) + 1; i++) {
            int yellowHeight = i + 1;

            if (yellow % yellowHeight != 0) {
                continue;
            }

            int yellowWidth = (yellow / yellowHeight);
            int sum = (yellowWidth + 2) * 2 + yellowHeight * 2;
            if(sum == brown) {
                answer[0] = yellowWidth + 2;
                answer[1] = yellowHeight + 2;
                break;
            }
        }

        return answer;
    }
}