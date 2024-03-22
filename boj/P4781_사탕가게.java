package org.example.boj;

import java.util.*;
import java.io.*;
public class P4781_사탕가게 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int n = sc.nextInt(); // 사탕 종류의 수
            int m = (int) Math.round(sc.nextDouble()*100);
            if(n == 0 && m == 0) break;
            int[] dp = new int[m + 1]; // 낸 돈 i에서 최대 칼로리 저장
            for(int i = 0; i < n; i++) {
                int c = sc.nextInt();
                int p = (int) Math.round(sc.nextDouble()*100);;
                for(int k = p; k <= m; k++) {
                    if(dp[k] < dp[k - p] + c) {
                        dp[k] = dp[k - p] + c;
                    }
                }
            }
            System.out.println(dp[m]);
        }
    }
}
