package org.example.inflearn.s1;

import java.util.Scanner;

public class P7 {
    public static String solution(String str) {
        str = str.toLowerCase();
        int lt = 0, rt = str.length()-1;
        while (lt < rt) {
            if (str.charAt(lt) != str.charAt(rt)) return "NO";
            lt ++;
            rt --;
        }
        return "YES";
    }

    public static String solution2(String str) {
        str = str.toLowerCase();
        int len = str.length();
        for (int i = 0; i < len/2; i++) {
            if (str.charAt(i) != str.charAt(len-1-i)) return "NO";
        }

        return "YES";
    }

    public static String solution3(String str) {
        String tmp = new StringBuilder(str).reverse().toString();
        if (tmp.equalsIgnoreCase(str)) return "YES";
        else return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution3(str));
    }
}
