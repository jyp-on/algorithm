package org.example.inflearn.s8;

import java.util.ArrayList;
import java.util.Scanner;

public class P14_피자배달거리_삼성기출 {
    static int n, m;
    static int[] combi;
    static ArrayList<Point> pz=new ArrayList<>();
    static ArrayList<Point> hs=new ArrayList<>();
    static int answer=Integer.MAX_VALUE; // 각 집의 피자배달거리의 합
    public static void DFS(int L, int s) { // 조합
        if(L==m){
            int sum=0;// 조합으로 뽑은 피자 집들과 집과의 거리 합

            for(Point p : hs){
                int min_dist=Integer.MAX_VALUE;
                for(int c : combi){ //피자집의 index == c
                    min_dist=Math.min(min_dist, Math.abs(p.x-pz.get(c).x) + Math.abs(p.y-pz.get(c).y));
                }
                sum+=min_dist;
            }

            answer=Math.min(answer, sum);
        }else{
            for(int i=s; i<pz.size(); i++){
                combi[L]=i;
                DFS(L+1, i+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        combi=new int[m];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int v = sc.nextInt();
                if(v==1) hs.add(new Point(i, j));
                if(v==2) pz.add(new Point(i, j));
            }
        }

        DFS(0, 0);
        System.out.println(answer);
    }
}
