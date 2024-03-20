package org.example.inflearn.normal.s7;

import java.util.*;
class P2 {
    public int solution(int[] pool, int a, int b, int home){
        int[] ch = new int[10001];
        int b_cnt = 0;
        int L = 0;
        Queue<Integer> Q = new LinkedList<>(); // 위치
        Q.offer(0);
        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i = 0; i < len; i++) {
                int x = Q.poll();
                int ax = x + a;
                int bx = x - b;
                boolean flagA = false;
                boolean flagB = false;
                if(ax==home || bx == home) return L+1;
                for(int p : pool) { // 못가는 곳일 경우
                    if(p == ax) flagA = true;
                    if(p == bx) flagB = true;
                }
                if(ax<10001 && !flagA && ch[ax]==0) {
                    ch[ax] = 1;
                    Q.offer(ax);
                    b_cnt = 0;
                }
                if(bx>=0 && !flagB && b_cnt<2 && ch[bx]==0) {
                    ch[bx] = 1;
                    Q.offer(bx);
                    b_cnt++;
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args){
        P2 T = new P2();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}