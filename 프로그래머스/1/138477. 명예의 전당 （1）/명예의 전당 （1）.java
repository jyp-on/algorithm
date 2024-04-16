import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        int ans_idx = 0;
        for(int s : score) {
            if(pq.size() < k) {
                pq.offer(s);
            }
            else {
                if(pq.peek() < s) {
                    pq.poll();
                    pq.offer(s);
                }
            }
            answer[ans_idx++] = pq.peek();
        }
        return answer;
    }
}