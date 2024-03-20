package org.example.inflearn.normal.s7;

import java.util.*;
class P1 {
    public int solution(int[] nums){
        int n = nums.length;
        int L = 0;
        int[] ch = new int[n];
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(0);
        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i = 0; i < len; i++) {
                int x = Q.poll();
                for(int j = 1; j <= nums[x]; j++) {
                    int nx = x + j;
                    if(nx == n-1) return L+1;
                    if(nx < n && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args){
        P1 T = new P1();
        System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}