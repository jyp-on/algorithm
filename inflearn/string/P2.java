package org.example.inflearn.string;

import java.util.Scanner;

public class P2 {

    public static String solution(String str) {
        String answer = "";
        for (char x : str.toCharArray()) {
            if (Character.isLowerCase(x)) answer += Character.toUpperCase(x);
            else answer += Character.toLowerCase(x);
        }
        return answer;
    }

    // 대문자 아스키 범위 65~90 (A~Z)
    // 소문자 아스키 범위 97~122 (a~z)
    // 소문자에서 32 빼면 대문자
    public static String solution2(String str) {
        String answer = "";
        for (char x : str.toCharArray()) {
            if (x >= 65 && x <= 90) answer += (char) (x + 32);
            else answer += (char) (x - 32);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution2(str));
    }
}
