package org.example.inflearn.normal.s4;

import java.util.*;
class P1 {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length];
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int tmp = nums[i];
            int cnt = 0;
            while(tmp>0){
                cnt += (tmp % 2); // 나머지가 1이면 cnt 증가
                tmp = tmp / 2;
            }
            arr.add(new int[]{nums[i], cnt});
        }
        arr.sort((a, b) -> a[1]==b[1] ? a[0]-b[0] : a[1]-b[1]);
        for(int i=0; i<arr.size(); i++){
            answer[i] = arr.get(i)[0];
        }
        return answer;
    }

    public static void main(String[] args){
        P1 T = new P1();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}