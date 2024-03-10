package org.example.inflearn.basic.s5;

import java.util.Scanner;
import java.util.Stack;

public class P4_후위연산 {
    public static int solution(String str) {
        Stack<Integer> stack = new Stack<>();
        for(char x : str.toCharArray()) {
            if(Character.isDigit(x)) stack.push(x-48);
            else {
                int rt=stack.pop();
                int lt=stack.pop();
                stack.push(operation(lt,rt,x));
            }
        }
        return stack.pop();
    }

    public static int operation(int lt, int rt, char op) {
        switch (op) {
            case '+':
                return lt+rt;
            case '-':
                return lt-rt;
            case '*':
                return lt*rt;
            case '/':
                return lt/rt;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
