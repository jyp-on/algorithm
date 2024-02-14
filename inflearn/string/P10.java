package org.example.inflearn.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class P10 {
    public static ArrayList<Integer> solution(String str, char target) {
        ArrayList<Integer> answer = new ArrayList<>();
        char[] s = str.toCharArray();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == target) {
                set.add(i); // target의 idx 모음
            }
        }
        for (int j = 0; j < s.length; j++) {
            int min = Integer.MAX_VALUE;
            for (int idx : set) {
                int diff = Math.abs(idx - j);
                if (min > diff) {
                    min = diff;
                }
            }
            answer.add(min);
        }
        return answer;
    }

    public static int[] solution2(String s, char t) {
        int[] answer = new int[s.length()];
        int p = 1000; // 떨어진거리

        //왼쪽으로부터 떨어진거리
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                p = 0;
                answer[i] = p;
            } else {
                p++; // 왼쪽으로부터 더 멀어지니 ++
                answer[i] = p;
            }
        }
        p = 1000;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == t) p = 0;
            else {
                p++; // 오른쪽으로부터 더 멀어지니 ++
                answer[i] = Math.min(p, answer[i]); // 왼쪽으로부터 떨어진 값과 오른쪽으로 떨어진 값 중 작은 것
            }
        }
        return answer;
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char target = sc.next().charAt(0);
        for (int x : solution2(str, target)) {
            System.out.print(x + " ");
        }
    }
}
