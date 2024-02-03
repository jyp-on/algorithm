package org.example.number;

import java.util.Scanner;

public class P1929_소수구하기 {
    // 에라토스테네스의 체 : 해당수가 소수라면 그 수의 배수들은 약수가 있으므로 소수가 아님
    // A 배열에서 0인 곳을 지워진 수로 정의

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] A = new int[N+1];

        for (int i = 2; i <= N; i++) {
            A[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(N); i++) { // N이 a*b일 경우 a와 b 모두 N의 제곱근보다 클 수 없기 때문에 N의 제곱근까지만 탐색
            if (A[i] == 0) { // 지워진 수 일 경우
                continue;
            }
            for (int j = 2 * i; j <= N; j += i) { // 지워지지 않은 수의 배수들을 삭제
                A[j] = 0;
            }
        }

        for (int i = M; i <= N; i++) {
            if (A[i] != 0) {
                System.out.println(A[i]);
            }
        }
    }
}
