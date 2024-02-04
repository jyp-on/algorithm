package org.example.dp;

import java.util.Scanner;

/**
 * 최소한의 갯수를 구하는 우선순위
 * 1. 5로 나누어질 경우 -> sugar % 5
 * 2. 최대갯수의 5와 최소갯수의 3의 조합으로 이루어진 경우
 * 3. 3으로만 나누어질 경우 -> sugar % 3
 * 4. 그 외 -> -1
 */
public class P2839_설탕배달 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sugar = sc.nextInt();

        int bag = 0;
        boolean flag = false;

        while (sugar >= 0) {
            if (sugar % 5 == 0) { // 5로 나누어떨어질 경우
                bag += sugar / 5;
                System.out.println(bag);
                flag = true;
                break;
            }

            sugar -= 3;
            bag += 1;

            if (sugar == 1 || sugar == 2) { // 5나 3의 조합으로 안될경우
                System.out.println(-1);
                flag = true;
                break;
            }
        }
        if (!flag) { // 5와 3의 조합일 경우
            System.out.println(bag);
        }
    }
}
