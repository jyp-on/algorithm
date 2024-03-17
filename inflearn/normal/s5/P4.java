package org.example.inflearn.normal.s5;

import java.util.*;
class P4 {
    public int solution(int[] plantTime, int[] growTime){
        int answer = 0;
        int n = plantTime.length;
        int[][] line = new int[n][n];
        for(int i=0; i<n; i++){
            line[i][0] = plantTime[i];
            line[i][1] = growTime[i];
        }
        // growTime 이 큰것부터
        Arrays.sort(line, (a, b) -> b[1] - a[1]);
        int prev = 0;
        for(int i = 0; i < n; i++) {
            answer = Math.max(answer, prev + line[i][0] + line[i][1]);
            prev += line[i][0];
        }
        return answer;
    }

    public static void main(String[] args){
        P4 T = new P4();
        System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
        System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
        System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
        System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
    }
}
