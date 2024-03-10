package org.example.inflearn.basic.s8;

import java.util.Scanner;

public class P2_바둑이승차 {
    static int[] arr;
    static int c, n;
    static int answer=-1;
    public static void DFS(int L, int sum) {
        System.out.println("L : " + L + " sum : " + sum);

        if(sum>c) return;
        if(L==n) {
            answer = Math.max(answer, sum);
        }
        else {
            DFS(L+1, sum+arr[L]);
            DFS(L+1, sum);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        DFS(0,0);
        System.out.println(answer);
    }
}
