import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < ingredient.length; i++) {
            int ing = ingredient[i];
            // 비어있거나 3개 이하면 push
            if(stack.size() < 3) stack.push(ing);
            else { 
                if(ing == 1) { // 빵인 경우 밑에 3개로 햄버거 만들 수 있는지 체크
                    int s1 = stack.pop();
                    int s2 = stack.pop();
                    int s3 = stack.pop();
                    // 햄버거 만들수 있는 경우
                    if(s1 == 3 && s2 == 2 && s3 == 1) answer++; 
                    else { // 햄버거 못만드는 경우 원래 상태로 되돌리고 빵 추가
                        stack.add(s3); stack.add(s2); stack.add(s1);
                        stack.add(ing);
                    }
                } else stack.push(ing);
            }
        }
        return answer;
    }
}