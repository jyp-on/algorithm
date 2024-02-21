package org.example.inflearn.s4;

import java.util.HashMap;
import java.util.Scanner;

public class P1_학급회장 {
    public static char solution(int n, String str) {
        char answer=str.charAt(0);
        int max=-1;
        char[] s = str.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char x : s) map.put(x, map.getOrDefault(x, 0)+1);

        for(char x : map.keySet()) {
            if(max<map.get(x)) {
                answer=x;
                max=map.get(x);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(solution(n, str));
    }
}
