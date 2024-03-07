package org.example.inflearn.s9;

import java.util.Arrays;
import java.util.Scanner;

class People implements Comparable<People>{
    int h, w;
    public People(int h, int w){
        this.h=h;
        this.w=w;
    }

    @Override
    public int compareTo(People o) {
        return o.h-this.h; // 키 내림차순
    }
}

public class P1_씨름선수 {
    public static int solution(int n, People[] peoples){
        int answer=0;
        int max_w=Integer.MIN_VALUE;
        for(People p : peoples){
            if(p.w>max_w){
                answer++;
                max_w=p.w;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        People[] peoples = new People[n];
        for(int i=0; i<n; i++){
            peoples[i] = new People(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(peoples);
        System.out.println(solution(n, peoples));
    }
}
