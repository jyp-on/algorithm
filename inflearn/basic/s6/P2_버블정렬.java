package org.example.inflearn.basic.s6;

import java.util.Scanner;

public class P2_버블정렬 {
    public static int[] solution(int n, int[] arr) {
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-i-1; j++) { // 뒤쪽 숫자는 점진적으로 정렬된 수가 오기때문에 n-i-1까지만 루프
                if(arr[j]>arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
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
