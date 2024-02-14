package org.example.inflearn.string;

import java.util.Scanner;

public class P9 {
    // 0 ~ 9 를 아스키로하면 48 ~ 57
    public static int solution(String str) {
        String answer = "";
        char[] s = str.toCharArray();
        for (char x : s) {
            if (Character.isDigit(x)) {
                answer += x;
            }
        }
        return Integer.parseInt(answer); // 파싱하면서 앞에 0이 자동으로 사라짐
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }
}
