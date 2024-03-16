package org.example.inflearn.normal.s4;

import java.util.*;
class P2 {
    public int[] solution(int[] nums){
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++) hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
        Arrays.sort(nums);
        for(int x : nums){
            if(hm.get(x)==0) continue;
            answer.add(x);
            hm.put(x, hm.get(x)-1);
            hm.put(x*2, hm.get(x*2)-1);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args){
        P2 T = new P2();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}