package org.example.inflearn.basic.s2;

import java.util.ArrayList;
import java.util.Scanner;

public class P6_숫자뒤집기 {

    public static boolean isPrime(int n) {
        if (n == 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // 숫자 뒤집기
            int res = 0;
            int tmp = arr[i];
            while (tmp > 0) {
                int t = tmp % 10; // 맨 뒷자리 수
                res = (res * 10) + t; // 자릿수 하나씩 늘려가며 나머지 더하기
                tmp = tmp / 10;
            }

            if (isPrime(res)) answer.add(res);
        }

        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
