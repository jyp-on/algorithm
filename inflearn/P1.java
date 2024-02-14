package org.example.inflearn;

import java.util.Scanner;

public class P1 {
    public static int solution(String str, char t) {
        int answer = 0;
        str = str.toLowerCase();
        t = Character.toLowerCase(t);

        for (char x : str.toCharArray()) {
            if (x == t) answer++;
        }

        return answer;
    }

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        System.out.println(solution(str, c));
    }
}
