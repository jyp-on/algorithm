package org.example.inflearn.normal.s1;

import java.util.*;
public class P5_최대길이바이토닉수열 {
    public static int solution(int[] nums){
        int answer = 0;
        List<Integer> peaks = new ArrayList<Integer>();
        for(int i=1; i<nums.length-1; i++){
           if(nums[i]>nums[i-1] && nums[i]>nums[i+1]){
               peaks.add(i);
           }
        }
        for(int x : peaks){
            int cnt=1;
            int left = x;
            int right = x;
            while(left-1 >= 0){
                if(nums[left-1]<nums[left]){
                    left--;
                    cnt++;
                } else break;
            }
            while(right+1<nums.length){
                if(nums[right+1]<nums[right]){
                    right++;
                    cnt++;
                } else break;
            }
            answer=Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1}));
        System.out.println(solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
