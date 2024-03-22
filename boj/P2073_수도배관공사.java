package org.example.boj;

import java.util.*;

public class P2073_수도배관공사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt();
        int P = sc.nextInt();
        int[] dp = new int[D+1]; // 0 ~ D
        for(int i = 0; i < P; i++) {
            int L = sc.nextInt();
            int C = sc.nextInt();
            for(int j = D; j > L; j--) {
                if(dp[j-L] == 0) continue;
                dp[j] = Math.max(dp[j], Math.min(dp[j-L], C));
            }
            dp[L] = Math.max(dp[L], C);
        }
        System.out.println(dp[D]);
    }
}
