package org.example.inflearn.s7;

import java.util.Scanner;

public class P2 {
    public static void dfs(int n) {
        if(n==0) return;
        else {
            dfs(n/2);
            System.out.print(n%2+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dfs(n);
    }
}
