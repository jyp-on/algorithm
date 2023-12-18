package org.example.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        Long[] A = new Long[N];
        int count = 0;

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(A);

        for (int k = 0; k < N; k++) {
            long find = A[k];
            int i = 0;
            int j = N - 1;

            // 투 포인터 알고리즘
            while (i < j) {
                System.out.println("A[" + i + "] + A[" + j + "] = " + (A[i] + A[j]));

                if (A[i] + A[j] == find) {
                    if (i != k && j != k) { // 서로 다른 두 수의 합이여야 함.
                        count++;
                        break;
                    } else if (i == k) {
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                }
                else if (A[i] + A[j] < find) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        System.out.println(count);
        bf.close();
    }
}
