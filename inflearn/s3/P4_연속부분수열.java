package org.example.inflearn.s3;

import java.util.Scanner;

public class P4_연속부분수열 {
    public static int solution(int m, int[] arr) {
        int answer = 0;
        for(int i=0; i<arr.length; i++) {
            int sum=0;
            for(int j=i; j<arr.length; j++) {
                sum+=arr[j];
                if(sum>m) break;
                if(sum==m) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(m, arr));
    }
}
