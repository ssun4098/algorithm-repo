import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Node> q = new ArrayDeque<>();
        
        for(int i = 0; i < prices.length; i++) {
            if(q.isEmpty()) {
                q.add(new Node(i, prices[i]));
                continue;
            }
            while(true) {
                if(q.isEmpty()) {
                    break;
                }
                Node before = q.peekLast();
                if(before.getValue() > prices[i]) {
                    answer[before.getI()] = i - before.getI();
                    q.pollLast();
                    continue;
                }
                break;
            }
            q.add(new Node(i, prices[i]));
        }
        while(!q.isEmpty()) {
            Node n = q.poll();
            answer[n.getI()] = prices.length - n.getI() - 1;
        }
        return answer;
    }
    
    public class Node {
        int i;
        int value;
        
        public Node(int i, int value) {
            this.i = i;
            this.value = value;
        }
        
        public int getI() {
            return this.i;
        }
        
        public int getValue() {
            return this.value;
        }
    }
}