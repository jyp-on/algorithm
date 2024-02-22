package org.example.inflearn.s5;

import java.util.Scanner;
import java.util.Stack;

public class P1_올바른괄호 {
    // Stack
    public static String solution(String str) {
        Stack<Character> stack = new Stack<>();
        for(char x : str.toCharArray()) {
            if(x=='(') stack.add(x);
            else if(x==')') {
                if(stack.isEmpty()) return "NO";
                else stack.pop();
            }
        }
        if(!stack.isEmpty()) return "NO";
        else return "YES";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
