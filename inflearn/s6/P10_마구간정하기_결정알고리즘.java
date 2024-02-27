package org.example.inflearn.s6;

import java.util.Arrays;
import java.util.Scanner;

public class P10_마구간정하기_결정알고리즘 {
    public static int count(int dist, int[] arr) {
        int end=arr[0];
        int cnt=1;
        for(int i=1; i<arr.length; i++) {
            if(arr[i]-end >= dist) {
                cnt++;
                end=arr[i];
            }
        }
        return cnt;
    }
    public static int solution(int n, int c, int[] arr) {
        int answer=0;
        Arrays.sort(arr);
        int lt=1, rt=arr[n-1]-arr[0]; // 마구간 사이의 최소, 최대 거리

        while(lt<=rt) {
            int mid=(lt+rt)/2; // 마구간 사이의 거리
            int count = count(mid, arr);
            if(count >= c) {
                lt=mid+1; // c 개 이상의 마구간을 거친다면 마구간 사이의 거리를 늘려보기
                answer=mid;
            }
            else rt=mid-1; // c 개 미만의 마구간을 거치면 마구간 사이의 거리를 줄여야 함
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        System.out.println(solution(n, c, arr));
    }
}
