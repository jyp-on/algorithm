package org.example.inflearn.basic.s3;

import java.util.Scanner;

public class P3_최대매출구하기 {
    public static int solution(int k, int[] arr) {
        int answer = 0; // k일간의 최대 매출액
        int sum = 0;
        for(int i=0; i<k; i++) {
            sum += arr[i];
        }
        answer = sum;
        int p1=k-2, p2=k;
        while(p2<arr.length) {
            sum += (arr[p2++] - arr[p1++]);
            if(sum>answer) answer=sum;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(k, arr));
    }
}
