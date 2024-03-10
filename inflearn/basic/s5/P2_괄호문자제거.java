package org.example.inflearn.basic.s5;

import java.util.Scanner;
import java.util.Stack;

public class P2_괄호문자제거 {
    // Stack
    public static String solution(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        for(char x : str.toCharArray()) {
            if(x=='(') stack.add(x);
            else if(x==')') stack.pop();
            else { // 문자일 경우
                if(stack.isEmpty()) answer.append(x);
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
