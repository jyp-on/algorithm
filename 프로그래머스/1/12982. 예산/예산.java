import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int x : d) {
            if(budget >= x) {
                budget -= x;
                answer++;
            }
            else break;
        }
        return answer;
    }
}