package org.example.inflearn.basic.s4;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class P5_K번째큰수 {
    // 정렬을 지원하는 Set : TreeSet
    public static int solution(int n, int k, int[] arr) {
        int answer = -1;
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
        for(int i=0; i<n-2; i++) {
            for(int j=i+1; j<n-1; j++) {
                for(int t=j+1; t<n; t++) {
                    Tset.add(arr[i]+arr[j]+arr[t]);
                }
            }
        }
        int cnt=0;
        for(int x : Tset) {
            cnt++;
            if(cnt==k) return x;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n, k, arr));
    }
}
