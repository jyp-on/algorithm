package org.example.inflearn.s6;

import java.util.Scanner;

public class P5_중복확인 {
    public static String solution(int n, int[] arr) {
        int[] s = new int[10000001];
        for(int i=0; i<n; i++) {
            if(s[arr[i]]==1) return "D";
            s[arr[i]]=1;
        }
        return "U";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        System.out.println(solution(n, arr));
    }
}
