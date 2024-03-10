package org.example.inflearn.basic.s8;

import java.util.Scanner;

public class P4_중복순열구하기 {
    static int n, m;
    static int[] answer;
    public static void DFS(int L) {
        if(L==m) {
            for(int i=0; i<m; i++) System.out.print(answer[i] + " ");
            System.out.println();
        }
        else {
            for(int i=1; i<=n; i++) {
                answer[L]=i;
                DFS(L+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        answer = new int[m];
        DFS(0);
    }
}
