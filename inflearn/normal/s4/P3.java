package org.example.inflearn.normal.s4;
import java.util.*;
class P3 {
    public int solution(int[] nums, int k){
        int answer = 0;
        int n = nums.length;
        Arrays.sort(nums);
        LinkedList<Integer> gap = new LinkedList();
        for(int i=1; i<n; i+=2){
            gap.add(nums[i] - nums[i-1]);
        }
        gap.sort((a, b) -> Integer.compare(b, a)); // gap 내림차순
        for(int i=n-1; i>=0; i-=2){
            int a = nums[i]; // 큰수
            int b = nums[i-1]; // 작은 수
            if(!gap.isEmpty() && a - b == gap.peek() && k>0) {
                answer += a;
                k--;
                gap.remove();
            }
            else answer += b;
        }

        return answer;
    }

    public static void main(String[] args){
        P3 T = new P3();
        System.out.println(T.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
        System.out.println(T.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
        System.out.println(T.solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
        System.out.println(T.solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
        System.out.println(T.solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
    }
}