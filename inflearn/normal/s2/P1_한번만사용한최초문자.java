package org.example.inflearn.normal.s2;
import java.util.*;
public class P1_한번만사용한최초문자 {
    public static int solution(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : s.toCharArray()){
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        for(int i=0; i<s.length(); i++){
            if(map.get(s.charAt(i))==1) return i+1;
        }

        return -1;
    }

    public static void main(String[] args){
        System.out.println(solution("statitsics"));
        System.out.println(solution("aabb"));
        System.out.println(solution("stringshowtime"));
        System.out.println(solution("abcdeabcdfg"));
    }
}
