package org.example.inflearn.normal.s5;

import java.util.*;
class P2 {
    public int solution(int[] nums){
        int answer = 0;
        Arrays.sort(nums);
        int s = 0, e = nums.length-1;
        while(s<=e){
            if(nums[s] + nums[e] <= 5) {
                s++;
                e--;
                answer++;
            } else {
                answer++;
                e--;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        P2 T = new P2();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }
}
