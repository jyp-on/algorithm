import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int s : section) set.add(s);
        
        for(int i = 1; i <= n; i++) {
            if(set.contains(i)) {
                i+=m-1;
                answer++;
            }
        }
    
        return answer;
    }
}