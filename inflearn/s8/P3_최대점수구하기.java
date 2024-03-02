package org.example.inflearn.s8;

import java.util.Scanner;

public class P3_최대점수구하기 {
    static int scores[];
    static int times[];
    static int n, m, answer;
    public static void DFS(int L, int timeSum, int scoreSum) {
        if(timeSum>m) return; // 제한시간을 넘어갔을경우 백
        if(L==n) {
            answer = Math.max(answer, scoreSum);
        } else {
            DFS(L+1, timeSum + times[L], scoreSum + scores[L]);
            DFS(L+1, timeSum, scoreSum);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        scores = new int[n];
        times = new int[n];
        for(int i=0; i<n; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            scores[i]=a;
            times[i]=b;
        }
        DFS(0, 0, 0);
        System.out.println(answer);
    }
}
