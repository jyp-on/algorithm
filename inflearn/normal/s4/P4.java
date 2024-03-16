
package org.example.inflearn.normal.s4;

import java.util.*;
class P4 {
    public int solution(int[] score, int k){
        int answer = Integer.MAX_VALUE;
        int n = score.length;
        Arrays.sort(score);
        int s=0, e=k;
        while(e<n){
            int sum = 0;
            if(score[e-1] - score[s]<=10){
                for(int i=s; i<e; i++){
                    sum += score[i];
                }
                int avg = sum / k;
                answer = Math.min(answer, avg);
            }
            s++; e++;
        }
        return answer;
    }

    public static void main(String[] args){
        P4 T = new P4();
        System.out.println(T.solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
        System.out.println(T.solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
        System.out.println(T.solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5));
        System.out.println(T.solution(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5));
    }
}