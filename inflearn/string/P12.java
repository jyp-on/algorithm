package org.example.inflearn.string;

import java.util.Scanner;

public class P12 {
    public static String solution(int n, String str) {
        String answer = "";
        int dist = str.length() / n;
        str = str.replace("#", "1").replace("*", "0");

        for (int i = 0; i < str.length()-1; i+=dist) {
            String temp = str.substring(i, i + dist);
            int digit = Integer.parseInt(temp, 2); // 2진수를 10진수로 변경
            answer += (char) digit;
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
