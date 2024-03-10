package org.example.inflearn.basic.s10;

import java.util.Scanner;

public class P2_돌다리건너기 {
    static int[] dp;
    public static int solution(int n){
        dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3; i<=n; i++){
            dp[i]=dp[i-2]+dp[i-1];
        }
        return dp[n-1]+dp[n];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(solution(n));
    }
}
