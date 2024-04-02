import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int x : arr) {
            if(x % divisor == 0) answer.add(x);
        }
        Collections.sort(answer);
        if(answer.size() == 0) return new int[]{-1};
        else return answer.stream().mapToInt(i->i).toArray();
    }
}