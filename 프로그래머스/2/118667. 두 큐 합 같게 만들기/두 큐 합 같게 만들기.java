import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        long sum1 = 0, sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int x : queue1) {
            sum1 += x;
            q1.offer(x);
        }
        for(int x : queue2) {
            sum2 += x;
            q2.offer(x);
        }
        int cnt = 0;
        while(cnt < queue1.length*4) {
            if(sum1>sum2) {
                int x = q1.poll();
                sum1 -= x;
                sum2 += x;
                q2.offer(x);
            } else if(sum1<sum2) {
                int x = q2.poll();
                sum1 += x;
                sum2 -= x;
                q1.offer(x);
            } else {
                answer = cnt;
                break;
            }
            cnt++;
        }
        
        return answer;
    }
}