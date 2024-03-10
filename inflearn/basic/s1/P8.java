package org.example.inflearn.basic.s1;

import java.util.Scanner;

public class P8 {
    public static String solution(String str) {
        str = str.toUpperCase().replaceAll("[^A-Z]", ""); // A-Z가 아닌 것들을 빈 문자열로 변경
        String reverse = new StringBuilder(str).reverse().toString();
        if (reverse.equals(str)) return "YES";
        else return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }
}
