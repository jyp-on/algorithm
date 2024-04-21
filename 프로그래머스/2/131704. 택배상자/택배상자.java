import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> main = new Stack<>();
        Stack<Integer> sub = new Stack<>();
        for(int i=order.length; i>=1; i--) 
            main.add(i);
        
        for(int i=0; i<order.length;) {
            if(!main.isEmpty() && order[i] == main.peek()) {
                main.pop();
                answer++;
                i++;
            } else if(!sub.isEmpty() && order[i] == sub.peek()) {
                sub.pop();
                answer++;
                i++;
            } else {
                if(!main.isEmpty()) 
                    sub.add(main.pop());
                else // main이 비어있고 sub의 peek도 order에 맞는게 없다면 더이상 상자를 못 받음
                    break;
            }
        }
        
        return answer;
    }
}