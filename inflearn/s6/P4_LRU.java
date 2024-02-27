package org.example.inflearn.s6;

import java.util.*;

public class P4_LRU {
    public static int[] solution(int s, int[] plan) {
        int[] p = new int[s];
        for(int i=0; i<plan.length; i++) {
            boolean hit_flag = false;
            for(int j=0; j<p.length; j++) {
                // Cache Hit
                if(p[j]==plan[i]) {
                    for(int k=j-1; k>=0; k--) p[k+1]=p[k];
                    p[0]=plan[i];
                    hit_flag=true;
                    break;
                }
            }
            if(!hit_flag) {
                for(int k=s-2; k>=0; k--) p[k+1]=p[k];
                p[0]=plan[i];
            }
//            for(int x : p) System.out.print(x + " ");
//            System.out.println();
        }
        return p;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt(); // 캐쉬의 크기
        int n = sc.nextInt(); // 작업의 개수
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        for(int x : solution(s, arr)) {
            System.out.print(x + " ");
        }
    }
}
