package org.example.inflearn.s4;

import java.util.HashMap;
import java.util.Scanner;

public class P2_아나그램 {
    public static String solution(String s1, String s2) {
        HashMap<Character,Integer> m1 = new HashMap<>();
        HashMap<Character,Integer> m2 = new HashMap<>();
        for(char x : s1.toCharArray()) m1.put(x, m1.getOrDefault(x,0)+1);
        for(char x : s2.toCharArray()) m2.put(x, m2.getOrDefault(x,0)+1);

        for(char x : m1.keySet()) {
            if(m2.containsKey(x)) {
                if(m1.get(x)!=m2.get(x)) return "NO";
            } else {
                return "NO";
            }
        }

        return "YES";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(solution(s1, s2));
    }
}
