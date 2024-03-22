package org.example.boj;

import java.util.*;

public class P2579_계단오르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1]; // i번째 계단에서 얻을 수 있는 최대 점수 (점화식 dp[i] = dp[i-2] + dp[i-1])
        int[] score = new int[n+1]; // i 계단에서 얻는 점수
        for(int i = 1; i <= n; i++) {
            score[i] = sc.nextInt();
        }
        dp[1] = score[1];
        if(n > 1) dp[2] = score[1] + score[2];
        for(int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-2] + score[i], dp[i-3] + score[i-1] + score[i]);
        }
//        for(int x : dp) System.out.print(x + " ");
        System.out.println(dp[n]);
    }
}
