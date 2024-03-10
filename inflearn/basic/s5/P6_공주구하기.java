package org.example.inflearn.basic.s5;

import java.util.*;

public class P6_공주구하기 {
    // Queue
    public static int solution(int n, int k) {
        int answer=0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++) q.offer(i);

        while(!q.isEmpty()) {
            for(int i=1; i<k; i++) q.offer(q.poll());
            q.poll();
            if(q.size()==1) answer=q.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(solution(n, k));
    }
}
