package org.example.inflearn.s1;

import java.util.Scanner;

public class P11 {
    public static String solution(String str) {
        str += " "; // 맨마지막과 비교할것이 필요하므로 공백 추가
        char[] s = str.toCharArray();
        StringBuilder answer = new StringBuilder();
        char tmp = s[0];
        int cnt = 0;
        for (char x : s) {
            if (x == tmp) cnt ++;
            else {
                answer.append(tmp);
                if (cnt == 1) {
                    tmp = x;
                } else {
                    answer.append(cnt);
                    cnt = 1;
                    tmp = x;
                }
            }
        }
        return answer.toString();
    }

    public static String solution2(String str) {
        str += " "; // 맨마지막과 비교할것이 필요하므로 공백 추가
        String answer = "";
        int cnt = 1;
        for (int i = 0; i < str.length()-1; i++) {
            if (str.charAt(i) == str.charAt(i+1)) cnt++;
            else {
                answer += str.charAt(i);
                if (cnt > 1) answer += cnt;
                cnt = 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution2(str));
    }
}
