package org.example.inflearn.basic.s8;

import java.util.Scanner;

public class P8_수열추측하기 {
    static int n, f;
    static boolean flag=false;
    static int[][] dp = new int[10][10];
    static int[] b, p, ch;
    public static int combi(int nn, int rr) {
        if(rr==0 || (nn==rr)) return 1;
        if(dp[nn][rr] != 0) return dp[nn][rr];
        else return dp[nn][rr] = combi(nn - 1, rr - 1) + combi(nn - 1, rr);
    }

    public static void DFS(int L, int sum){
        if(flag) return;
        if(L==n){
            if(sum==f){
                for (int x : p) {
                    System.out.print(x+" ");
                }
                flag=true;
            }
        }else{
            for(int i=1; i<=n; i++){
                if(ch[i]==0){
                    ch[i]=1;
                    p[L]=i;
                    DFS(L+1, sum+p[L]*b[L]);
                    ch[i]=0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        f=sc.nextInt();
        b=new int[n];
        p=new int[n];
        ch=new int[n+1];
        for(int i=0; i<n; i++){
            b[i]=combi(n-1, i);
        }
        DFS(0,0);
    }
}
