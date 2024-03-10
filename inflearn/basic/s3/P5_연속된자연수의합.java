package org.example.inflearn.basic.s3;

import java.util.Scanner;

public class P5_연속된자연수의합 {
    public static int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n/2+1; i++) {
            int sum=0;
            for(int j=i; j<=n/2+1; j++) {
                sum+=j;
                if(sum>n) break;
                if(sum==n) {
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
        System.out.println(solution(n));
    }
}
