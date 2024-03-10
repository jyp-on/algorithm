package org.example.inflearn.basic.s7;

import java.util.Scanner;

public class P4_피보나치 {
    static int[] fibo;
    public static int dfs(int n) {
        if(fibo[n]!=0) return fibo[n]; // 메모이제이션 활용, 이미 기록한 값이면 바로 return
        if(n==1 || n==2) return fibo[n]=1;
        else return fibo[n] = dfs(n-2) + dfs(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fibo = new int[n+1];
        dfs(n);
        for(int i=1; i<=n; i++) System.out.print(fibo[i] + " ");
    }
}
