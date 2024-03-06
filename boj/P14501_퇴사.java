package org.example.boj;

import java.util.Scanner;

public class P14501_퇴사 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] D = new int[N+2]; // i일부터 퇴사일까지 얻을 수 있는 최대 수익. N+2까지 초기화하는 이유는 점화식 D[i] = D[i+1]을 적용하기 위해
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        for (int i = N; i >= 1; i--) {
            if (i + T[i] > N + 1) { // 일 못하는경우
                D[i] = D[i+1];
            } else {
                D[i] = Math.max(D[i+T[i]] + P[i], D[i+1]);
            }
        }

        System.out.println(D[1]);


    }
}
