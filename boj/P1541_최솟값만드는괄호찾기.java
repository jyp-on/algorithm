package org.example.boj;

import java.util.Scanner;

public class P1541_최솟값만드는괄호찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] chunks = input.split("-");
        int answer = 0;

        for (int i = 0; i < chunks.length; i++) {
            int temp = mySum(chunks[i]);
            if (i == 0) {
                answer += temp;
            } else {
                answer -= temp;
            }
        }

        System.out.println(answer);
    }

    static int mySum(String a) {
        int sum  = 0;
        String[] temp = a.split("\\+");
        for (int i = 0; i < temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }

        return sum;
    }
}
