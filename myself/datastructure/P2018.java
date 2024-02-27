package org.example.myself.datastructure;

import java.util.Scanner;

public class P2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;
        int sum = 1;
        int start_index = 1;
        int end_index = 1;

        while (end_index != N) {
            if (sum == N) {
                count ++;
                end_index ++;
                sum += end_index;
            } else if (sum > N) {
                sum -= start_index;
                start_index ++;
            } else if (sum < N) {
                end_index ++;
                sum += end_index;
            }

            System.out.println("start_index : " + start_index);
            System.out.println("end_index : " + end_index);
            System.out.println("sum : " + sum);
            System.out.println("count : " + count);
            System.out.println("--------------------------------");
        }

        System.out.println(count);
    }
}
