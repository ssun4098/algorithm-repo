import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


class Solution {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        // 과제를 시작 시간 기준으로 정렬
        Arrays.sort(plans, (a, b) -> LocalTime.parse(a[1], DateTimeFormatter.ofPattern("HH:mm"))
                .compareTo(LocalTime.parse(b[1], DateTimeFormatter.ofPattern("HH:mm"))));
        
        Deque<String[]> stack = new ArrayDeque<>();
        LocalTime currentTime = LocalTime.parse(plans[0][1], DateTimeFormatter.ofPattern("HH:mm"));
        
        for (int i = 0; i < plans.length; i++) {
            String[] currentPlan = plans[i];
            LocalTime startTime = LocalTime.parse(currentPlan[1], DateTimeFormatter.ofPattern("HH:mm"));
            int playtime = Integer.parseInt(currentPlan[2]);
            
            // 현재 시간과 시작 시간 사이의 차이 계산
            long diff = java.time.Duration.between(currentTime, startTime).toMinutes();
            
            // 스택에 있는 과제들을 처리
            while (diff > 0 && !stack.isEmpty()) {
                String[] prevPlan = stack.peek();
                int prevPlaytime = Integer.parseInt(prevPlan[2]);
                
                if (prevPlaytime <= diff) {
                    answer.add(prevPlan[0]);
                    diff -= prevPlaytime;
                    stack.pop();
                } else {
                    prevPlan[2] = String.valueOf(prevPlaytime - diff);
                    diff = 0;
                }
            }
            
            currentTime = startTime;
            stack.push(currentPlan);
        }
        
        // 스택에 남은 과제들을 처리
        while (!stack.isEmpty()) {
            answer.add(stack.pop()[0]);
        }
        
        return answer.toArray(new String[0]);
    }
}