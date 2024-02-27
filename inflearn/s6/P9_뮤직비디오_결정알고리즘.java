package org.example.inflearn.s6;

import java.util.Arrays;
import java.util.Scanner;

public class P9_뮤직비디오_결정알고리즘 {
    // 이분탐색을 이용한 결정 알고리즘
    public static int count(int capacity, int[] arr) {
        int cnt=1, sum=0;
        for(int x : arr) {
            if(sum+x <= capacity) sum+=x;
            else {
                cnt++;
                sum=x;
            }
        }
        return cnt;
    }
    public static int solution(int n, int m, int[] arr) {
        int answer= 0;
        int lt= Arrays.stream(arr).max().getAsInt();
        int rt= Arrays.stream(arr).sum();
        while(lt<=rt) {
            int mid=(lt+rt)/2;
            if(count(mid, arr)<=m) {
                answer=mid;
                rt=mid-1;
            } else lt=mid+1;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        System.out.println(solution(n, m, arr));
    }
}
