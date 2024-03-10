package org.example.inflearn.basic.s3;

import java.util.Scanner;

public class P6_최대길이연속부분수열 {
    public static int solution(int k, int[] arr) {
        int answer = 0;
        for(int i=0; i<arr.length; i++) {
            int k_cnt=0; // 0->1 로 바꾼 경우
            int cnt=0; // 1의 갯수
            for(int j=i; j<arr.length; j++) {
                if(arr[j]==0) {
                    if(k_cnt==k) break;
                    k_cnt++;
                    cnt++;
                }
                else if(arr[j]==1) cnt++;
            }
            answer = Math.max(answer, cnt);
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
