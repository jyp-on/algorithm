package org.example.inflearn.normal.s5;

import java.util.*;
class P1 {
    public int solution(int[] nums, int m){
        int answer = 0;
        Arrays.sort(nums);
        int n = nums.length;
//        for(int x : nums) System.out.print(x + " ");
        int s = 0, e = n-1;
        while(s<e){
            if(nums[s]+nums[e]<=m){
                answer++;
                s++;
                e--;
            } else {
                answer++;
                e--;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        P1 T = new P1();
        System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(T.solution(new int[]{86, 95, 107, 67, 38, 49, 116, 22, 78, 53}, 150));
        System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
    }
}