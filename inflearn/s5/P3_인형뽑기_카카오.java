package org.example.inflearn.s5;

import java.util.Scanner;
import java.util.Stack;

public class P3_인형뽑기_카카오 {
    // Stack
    public static int solution(int n, int m, int[][] arr, int[] moves) {
        int answer=0;
        Stack<Integer> bucket = new Stack<>();

        for(int move=1; move<=m; move++) { // moves
            int mv = moves[move];
            for(int i=1; i<=n; i++) {
                if(arr[i][mv]!=0) {
                    if(bucket.isEmpty()) {
                        bucket.add(arr[i][mv]);
                        arr[i][mv]=0;
                    }
                    else {
                        if(bucket.peek()==arr[i][mv]) {
                            arr[i][mv]=0;
                            bucket.pop();
                            answer+=2;
                        } else {
                            bucket.add(arr[i][mv]);
                            arr[i][mv]=0;
                        }
                    }
//                    System.out.println("mv : " + mv + ", bucket : " + bucket + ", answer : " + answer);
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] moves = new int[m+1];
        for(int i=1; i<=m; i++) moves[i] = sc.nextInt();
        System.out.println(solution(n, m, arr, moves));
    }
}
