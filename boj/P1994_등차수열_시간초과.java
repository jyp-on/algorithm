package org.example.boj;

import java.util.*;

public class P1994_등차수열_시간초과 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if(arr[i] > max) max = arr[i];
            if(arr[i] < min) min = arr[i];
        }
        Arrays.sort(arr);
        int[] dp = new int[max-min + 1]; // 제일 큰 수에서 제일 작은수의 차이보다 등차가 클수 없음
        for(int i = 0; i <= max-min; i++) { // 등차가 i일때
            int cnt = 1, a = 0, b = 1; // a와 b는 idx, cnt는 등차가 i인 수열의 길이
            while(b<arr.length) {
                int d = arr[b]-arr[a]; // 등차
                if(d>i) { // 현재 등차 d는 앞으로 계속 커지는데 i보다 이미 크다면 break 해야함
                    break;
                } else if(d<i){ // 현재 등차가 i보다 작다면 i가 될수있으니 b를 증가
                    b++;
                } else { // 등차가 맞다면 a와 b를 옮기고 cnt 증가
                    a = b;
                    b++; cnt++;
                }
            }
            dp[i] = cnt;
        }
        int answer = 0;
        for(int x : dp) if(x > answer) answer = x;
        System.out.println(answer);
    }
}
