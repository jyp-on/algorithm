package org.example.inflearn.basic.s2;

import java.util.Scanner;

public class P10_봉우리 {
    public static int solution(int n, int[][] arr) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int tmp = arr[i][j];
                // 좌 우
                if (tmp > arr[i][j-1] && tmp > arr[i][j+1]) {
                    // 상 하
                    if (tmp > arr[i-1][j] && tmp > arr[i+1][j]) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+2][n+2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, arr));
    }
}
