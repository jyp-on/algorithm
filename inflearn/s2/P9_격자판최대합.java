package org.example.inflearn.s2;

import java.util.Scanner;

public class P9_격자판최대합 {
    public static int solution(int n, int[][] arr) {
        int answer = Integer.MIN_VALUE;

        int row_max = 0; // 행의 최대합
        int col_max = 0; // 열의 최대합
        int cross_max; // 대각선의 최대합

        // 행, 열 최대합
        for (int i = 0; i < n; i++) {
            int row_sum = 0, col_sum = 0;
            for (int j = 0; j < n; j++) {
                row_sum += arr[i][j];
                col_sum += arr[j][i];
            }
            row_max = Math.max(row_sum, row_max);
            col_max = Math.max(col_sum, col_max);
        }

        //대각선 최대합
        int sum_lt = 0, sum_rt = 0;
        for (int i = 0; i < n; i++) {
            sum_lt += arr[i][i];
            sum_rt += arr[i][n-i-1];
        }

        cross_max = Math.max(sum_lt, sum_rt);
        answer = Math.max(row_max, col_max);
        answer = Math.max(answer, cross_max);
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, arr));
    }
}
