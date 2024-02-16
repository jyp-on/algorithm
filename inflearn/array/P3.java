package org.example.inflearn.array;

import java.util.Scanner;

public class P3 {
    public static char[] solution(int n, int[] arr1, int[] arr2) {
        char[] answer = new char[n];
        for (int i = 0; i < n; i++) {
            answer[i] = whoIsWinner(arr1[i], arr2[i]);
        }
        return answer;
    }

    public static char whoIsWinner(int A, int B) {
        if (A == B) {
            return 'D';
        } else if ((A == 1 && B == 3) || (A == 2 && B == 1) || (A == 3 && B == 2)){ // A가 이기는경우
            return 'A';
        } else { // B가 이기는 경우
            return 'B';
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        for (char x : solution(n, arr1, arr2)) {
            System.out.println(x);
        }
    }
}
