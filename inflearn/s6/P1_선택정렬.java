package org.example.inflearn.s6;

import java.util.Scanner;

public class P1_선택정렬 {
    public static int[] solution(int n, int[] arr) {
        // i 오른쪽에서 i보다 가장 작은 원소를 i와 교체
        for(int i=0; i<n-1; i++) {
            int min_idx=i;
            for(int j=i+1; j<n; j++) {
                if(arr[min_idx]>arr[j]) min_idx=j;
            }
            int tmp=arr[i];
            arr[i]=arr[min_idx];
            arr[min_idx]=tmp;
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        for(int x : solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
