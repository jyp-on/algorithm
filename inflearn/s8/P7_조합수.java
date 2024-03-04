package org.example.inflearn.s8;

import java.util.Scanner;

public class P7_조합수 {
    static int n, r;
    static int dp[][];
    public static int DFS(int nn, int rr) {
        if(rr==0 || (nn==rr)) return 1;
        if(dp[nn][rr] != 0) return dp[nn][rr];
        else {
            int t = DFS(nn-1, rr-1) + DFS(nn-1, rr);
            dp[nn][rr]=t;
            return t;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        r=sc.nextInt();
        dp=new int[n+1][r+1];
        System.out.println(DFS(n, r));
    }
}
