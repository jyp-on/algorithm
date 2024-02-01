package org.example.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253_투포인터 {
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
            long find = A[k]; // 판별의 대상이 되는 수
            int i = 0;
            int j = N - 1;

            // 투 포인터 알고리즘
            while (i < j) {
//                System.out.println("A[" + i + "] + A[" + j + "] = " + (A[i] + A[j]));

                if (A[i] + A[j] == find) {
                    if (i != k && j != k) { // 서로 다른 두 수의 합일 경우
                        count++;
                        break;
                    } else if (i == k) { // 자기 자신을 포함한 경우
                        i++;
                    } else if (j == k) { // 자기 자신을 포함한 경우
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
