package org.example.inflearn.s8;

import java.util.Scanner;

public class P1_합이같은부분집합 {
    static String answer="NO";
    static int total, n = 0;
    static int[] arr;
    static boolean flag=false;
    public static void DFS(int L, int sum) {
//        System.out.println("L : " + L + ", sum : " + sum);
        if(flag) return;
        if(sum>total/2) return;
        if(L==n) {
            if((total-sum)==sum) {
                answer="YES";
                flag=true;
            }
        }
        else {
            DFS(L+1, sum+arr[L]);
            DFS(L+1, sum);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i]=sc.nextInt();
            total+=arr[i];
        }
        DFS(0, 0);
        System.out.println(answer);
    }
}
