package org.example.search;

import java.util.Arrays;
import java.util.Scanner;

public class P1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);
        int M = sc.nextInt(); // 찾아야 하는 숫자의 개수

        for (int i = 0; i < M; i++) {
            boolean find = false;
            int target = sc.nextInt();

            // binary search
            int start = 0;
            int end = A.length - 1;

            while(start <= end) {
                int mid_idx = (start + end) / 2;
                int mid_val = A[mid_idx];
                if (mid_val == target) {
                    System.out.println(1);
                    find = true;
                    break;
                } else if (mid_val > target) {
                    end = mid_idx - 1;
                } else {
                    start = mid_idx + 1;
                }
            }

            if (!find) System.out.println(0);
        }
    }
}
