import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        int ans_idx = 0;
        for(int s : score) {
            pq.offer(s);
            if(pq.size() > k)
                pq.poll();
            
            answer[ans_idx++] = pq.peek();
        }
        return answer;
    }
}