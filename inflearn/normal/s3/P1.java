package org.example.inflearn.normal.s3;
import java.util.*;
public class P1 {
    public int solution(int[] nums){
        int answer = 1;
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for(int x : nums){
            if(min>x) min=x;
            set.add(x);
        }
        while(true){
            if(set.contains(++min)) answer++;
            else break;
        }
        return answer;
    }

    public static void main(String[] args){
        P1 T = new P1();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
