package org.example.myself.greedy;

import java.util.Scanner;

public class P11047 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 동전 수
        int K = sc.nextInt(); // 목표 금액

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int cnt = 0;

        for (int i = N-1; i > 0; i--) {
            if (arr[i] < K) {
                cnt += (K / arr[i]);
                K %= arr[i];
            }
        }

        System.out.println(cnt);
    }
}
