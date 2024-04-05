import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<int[]> stack = new Stack<>(); // idx, value
        for(int i = 0; i < numbers.length; i++) {
            if(stack.isEmpty() || stack.peek()[1] >= numbers[i]) stack.add(new int[]{i, numbers[i]});
            else {
                while(!stack.isEmpty() && stack.peek()[1] < numbers[i]) {
                    int idx = stack.pop()[0];
                    answer[idx] = numbers[i];
                }
                stack.add(new int[]{i, numbers[i]});
            }
        }
        while(!stack.isEmpty()) {
            int[] p = stack.pop();
            answer[p[0]] = -1;
        }
        return answer;
    }
}