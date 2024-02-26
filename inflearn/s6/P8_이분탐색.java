package org.example.inflearn.s6;

import java.util.Arrays;
import java.util.Scanner;

public class P8_이분탐색 {
    public static int solution(int n, int target, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt=0, rt=n-1;
        while(lt<=rt) {
            int mid=(lt+rt)/2;
            if(arr[mid]==target) return mid+1;
            else if(arr[mid]<target) lt=mid+1;
            else rt=mid-1;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        System.out.println(solution(n, target, arr));
    }
}
