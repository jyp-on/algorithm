package org.example.inflearn.normal.s5;

import java.util.*;
class P3 {
    public int solution(int n, int[] nums){
        int answer = 0;
        int[][] line = new int[nums.length][nums.length];
        for(int i=0; i<nums.length; i++) {
            line[i][0] = Math.max(0, i-nums[i]);
            line[i][1] = Math.min(n, i+nums[i]);
        }
        // 시작지점 오름차순
        Arrays.sort(line, (a, b) -> a[0] - b[0]);
        int s = 0, e = 0, i = 0;
        while(i < line.length){
            while(i < line.length && line[i][0] <= s) {
                e = Math.max(e, line[i][1]);
                i++;
            }
            answer++;
            if(e == n) return answer;
            if(s == e) return -1;
            s = e;
        }
        System.out.println(s + " " + e);
        return answer;
    }

    public static void main(String[] args){
        P3 T = new P3();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}
