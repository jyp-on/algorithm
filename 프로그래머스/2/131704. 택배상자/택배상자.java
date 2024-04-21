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
                else 
                    break;
            }
        }
        
        return answer;
    }
}