package org.example.boj;

import java.util.Scanner;

public class P1463_1로만들기_BottomUp {
    static int N;
    static int D[]; //D[i]는 i에서 1로 만드는데 걸리는 최소 연산 횟수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        D = new int[N+1];
        D[1] = 0;

        for (int i = 2; i <=N; i++) {
            D[i] = D[i-1] + 1; // (i-1이 1이되는데 필요한연산) + 1
            if (i%2 == 0) D[i] = Math.min(D[i], D[i/2] + 1); // 2로 나누어진다면 위에서 구한 D[i]와 비교하여 더 작은 값으로 대체
            if (i%3 == 0) D[i] = Math.min(D[i], D[i/3] + 1); // 3로 나누어진다면 위에서 구한 D[i]와 비교하여 더 작은 값으로 대체
        }

        System.out.println(D[N]);
    }
}
