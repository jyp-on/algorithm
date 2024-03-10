package org.example.inflearn.basic.s6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P6_장난꾸러기 {
    public static ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        for(int i=0; i<n; i++) {
            if(sorted[i]!=arr[i]) answer.add(i+1);
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        for(int x : solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
