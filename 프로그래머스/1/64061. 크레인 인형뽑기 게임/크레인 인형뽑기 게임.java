import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int row = board.length;
        for(int move : moves) {
            for(int r = 0; r < row; r++) {
                int item = board[r][move-1];
                if(item != 0) {
                    if(stack.isEmpty()) {
                        stack.push(item);
                        board[r][move-1] = 0;
                    } else {
                        if(stack.peek() == item) {
                            stack.pop();
                            answer += 2;
                            board[r][move-1] = 0;
                        } else {
                            stack.push(item);
                            board[r][move-1] = 0;
                        }
                    }
                    break;
                }
            }
            // System.out.println(stack);
        }
        
        return answer;
    }
}