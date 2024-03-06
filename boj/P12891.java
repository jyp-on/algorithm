package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12891 {
    // 만족해야 하는 ACGT의 최소 개수
    static int[] condition = new int[4];
    // 현재 ACGT의 개수
    static int[] current_condition = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int s_size = Integer.parseInt(st.nextToken());
        int p_size = Integer.parseInt(st.nextToken());
        int count = 0;

        char[] S = bf.readLine().toCharArray();

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < 4; i++) {
            condition[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < p_size; i++) {
            addCount(S[i]);
        }

        if (isValidCondition()) count ++;

        for (int i = 0; i < s_size - p_size; i++) {
            removeCount(S[i]);
            addCount(S[i + p_size]);
            if (isValidCondition()) count ++;
        }

        System.out.println(count);
    }

    private static void addCount(char input) {
        switch (input) {
            case 'A':
                current_condition[0] ++;
                break;
            case 'C':
                current_condition[1] ++;
                break;
            case 'G':
                current_condition[2] ++;
                break;
            case 'T':
                current_condition[3] ++;
                break;
        }
    }

    private static void removeCount(char input) {
        switch (input) {
            case 'A':
                current_condition[0] --;
                break;
            case 'C':
                current_condition[1] --;
                break;
            case 'G':
                current_condition[2] --;
                break;
            case 'T':
                current_condition[3] --;
                break;
        }
    }

    // A, C, G, T의 최소 개수가 만족하는지 return
    private static boolean isValidCondition() {
        for (int i = 0; i < 4; i++) {
            if (condition[i] > current_condition[i]) {
                return false;
            }
        }
        return true;
    }
}
