import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        ArrayList<Integer> bucket = new ArrayList<>();
        int idx = score.length-1;
        
        while(idx>=0) {
            bucket.add(score[idx--]);
            
            if(bucket.size() == m) {
                answer += (bucket.get(m-1) * m);
                bucket.clear();
            }
        }
        return answer;
    }
}