package org.example.inflearn.basic.s5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P7_수업설계 {
    // Queue
    public static String solution(String need, String str) {
        Queue<Character> q = new LinkedList<>();
        for(char x : need.toCharArray()) q.offer(x);
        for(char x : str.toCharArray()) {
            if(q.contains(x)) {
                if(q.poll()!=x) return "NO";
            }
        }
        if(!q.isEmpty()) return "NO";
        else return "YES";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String need = sc.next();
        String str = sc.next();
        System.out.println(solution(need, str));
    }
}
