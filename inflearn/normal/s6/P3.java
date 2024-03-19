package org.example.inflearn.normal.s6;

import java.util.*;
class P3 {
    int[][] arr;
    int[] ch;
    int answer, m;
    void DFS(int L, int s) {
        if(L==m/2) {
            int sumA = 0;
            int sumB = 0;
            for(int i = 0; i < m; i++) {
                if(ch[i]==1) sumA += arr[i][0]; // 흰돌
                else sumB += arr[i][1]; // 검은돌
            }
            answer = Math.min(answer, Math.abs(sumA - sumB));
        } else {
            for(int i = s; i < m; i++) {
                if(ch[i]==0) {
                    ch[i] = 1;
                    DFS(L+1, i+1);
                    ch[i] = 0;
                }
            }
        }
    }
    public int solution(int[][] cans){
        answer = Integer.MAX_VALUE;
        m = cans.length;
        ch = new int[m];
        arr = cans;
        DFS(0, 0); // 3명을 고르는 조합
        return answer;
    }

    public static void main(String[] args){
        P3 T = new P3();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}}));
    }
}
