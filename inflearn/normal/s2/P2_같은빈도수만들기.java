package org.example.inflearn.normal.s2;
import java.util.*;
public class P2_같은빈도수만들기 {
    public int[] solution(String s){
        int[] answer = new int[5];
        HashMap<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(char x : s.toCharArray()){
            int v = map.getOrDefault(x, 0)+1;
            if(v>max) max=v;
            map.put(x, v);
        }
        for(int i=0; i<5; i++){
            char x = (char) (97+i);
            answer[i] = max - map.getOrDefault(x, 0);
        }

        return answer;
    }

    public static void main(String[] args){
        P2_같은빈도수만들기 T = new P2_같은빈도수만들기();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
