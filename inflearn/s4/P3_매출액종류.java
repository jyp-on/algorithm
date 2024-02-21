package org.example.inflearn.s4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class P3_매출액종류 {
    public static ArrayList<Integer> solution(int[] arr, int k) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<k; i++) map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        answer.add(map.size());

        int p1=0, p2=k;
        while(p2<arr.length) {
            map.put(arr[p1], map.get(arr[p1])-1);
            map.put(arr[p2], map.getOrDefault(arr[p2],0)+1);

            if(map.get(arr[p1])==0) map.remove(arr[p1]);
            p1++;
            p2++;

            answer.add(map.size());
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int x : solution(arr, k)) {
            System.out.print(x + " ");
        }
    }
}
