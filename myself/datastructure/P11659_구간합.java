package org.example.myself.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11659_구간합 {
    public static void main(String[] args) throws IOException {
        // System.in 을 읽어서 버퍼로 읽어들임
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // buffer에 있는 String을 " \t\n\r\f" 기준으로 tokenize 함
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        // 데이터의 개수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 질의 개수
        int M = Integer.parseInt(stringTokenizer.nextToken());

        // 구간합 배열 S[0] ~ S[N]
        long[] S = new long[N + 1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        // S[i] = S[i-1] + A[i]
        for (int i = 1; i <= N; i++) {
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int q = 0; q < M; q++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());

            // 구간합 -> X ~ Y = S[Y] - S[X - 1]
            System.out.println(S[end] - S[start - 1]);
        }
    }


}
