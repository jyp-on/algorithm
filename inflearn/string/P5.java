package org.example.inflearn.string;

import java.util.Scanner;

public class P5 {
    public static String solution(String str) {
        char[] arr = str.toCharArray();
        int lt = 0, rt = arr.length - 1;
        while (lt < rt) {
            if (!Character.isAlphabetic(arr[lt])) lt ++;
            else if (!Character.isAlphabetic(arr[rt])) rt --;
            else {
                char tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;
                lt ++;
                rt --;
            }
        }
        return String.valueOf(arr);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
