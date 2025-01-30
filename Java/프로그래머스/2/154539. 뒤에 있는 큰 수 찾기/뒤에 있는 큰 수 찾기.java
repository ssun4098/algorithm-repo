import java.util.*;

class Solution {
    public int[] solution(int[] array) {
        ArrayDeque<Node> ad = new ArrayDeque<>();
        int[] newArray = new int[array.length];
        Arrays.fill(newArray, -1);

        for(int i = 0; i < array.length; i++) {
            while(!ad.isEmpty()) {
                Node node = ad.peekLast();
                if(node.getValue() < array[i]) {
                    newArray[node.getOrder()] = array[i];
                    ad.pollLast();
                } else {
                    break;
                }
            }
            ad.add(new Node(i, array[i]));
        }


        return newArray;
    }
}

class Node {
    private int order;
    private int value;

    public Node(int order, int value) {
        this.order = order;
        this.value = value;
    }

    public int getOrder() {
        return order;
    }

    public int getValue() {
        return value;
    }
}