package org.example.inflearn.array;

import java.util.Arrays;
import java.util.Scanner;

public class P8 {
    public static int[] solution(int n, int[] arr) {
        int[] answer = new int[n];
        Arrays.fill(answer, 1);

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i] < arr[j]) answer[i]++;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
