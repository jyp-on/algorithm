package org.example.inflearn.normal.s7;

import java.util.*;
class P3 {
    public int solution(int s, int e){
        int L = 0;
        int[][] ch = new int[2][200001];
        Queue<Integer> Q = new LinkedList<>(); // 현수의 좌표들
        ch[0][s] = 1; // 홀 짝 단위로 겹칠 수 있음.
        Q.offer(s);
        while(!Q.isEmpty()) {
            int len = Q.size();
            L++;
            for(int i = 0; i < len; i++) {
                int x = Q.poll();
                for(int nx : new int[]{x+1, x-1, x*2}) {
                    if(nx >= 0 && nx <= 200000 && ch[L%2][nx] == 0) {
                        ch[L%2][nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            e += L;
            if(e > 200000) return -1;
            if(ch[L%2][e] == 1) return L;
        }

        return -1;
    }

    public static void main(String[] args){
        P3 T = new P3();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}