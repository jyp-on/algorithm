package org.example.inflearn.string;

import java.util.HashSet;
import java.util.Scanner;

public class P6 {
    public static String solution(String str) {
        String answer = "";
        char[] arr = str.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (char x : arr) {
            if (!set.contains(x)) {
                set.add(x);
                answer += x;
            }
        }

        return answer;
    }

    // indexOf(char) : 해당 문자가 첫번째로 나올때의 index return
    public static String solution2(String str) {
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i) answer += str.charAt(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution2(str));
    }
}
