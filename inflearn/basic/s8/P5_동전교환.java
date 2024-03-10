package org.example.inflearn.basic.s8;

import java.util.Arrays;
import java.util.Scanner;

public class P5_동전교환 {
    static int n, m;
    static int[] coins;
    static int answer=Integer.MAX_VALUE;
    public static void DFS(int L, int sum) {
        if(sum>m) return;
        if(L>=answer) return;
        if(sum==m) {
//            System.out.println(sum + " " + L);
            answer=Math.min(answer, L);
        }
        else {
            for(int i=0; i<n; i++){
                DFS(L+1, sum+coins[n-1-i]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        coins=new int[n];
        for(int i=0; i<n; i++){
            coins[i]=sc.nextInt();
        }
        Arrays.sort(coins);
        m=sc.nextInt();
        DFS(0, 0);
        System.out.println(answer);
    }
}
