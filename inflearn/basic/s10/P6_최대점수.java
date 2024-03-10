package org.example.inflearn.basic.s10;

import java.util.Arrays;
import java.util.Scanner;

public class P6_최대점수 {
    static int n, m;
    static int[] ps, pt, dy;
    public static int solution(){
        int answer;
        for(int i=0; i<n; i++){
            for(int j=m; j>=pt[i]; j--){
                dy[j]=Math.max(dy[j], dy[j-pt[i]]+ps[i]);
            }
//            for(int x : dy) System.out.print(x+" ");
//            System.out.println();
        }
        answer = dy[m];
        return answer;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        ps=new int[n];
        pt=new int[n];
        dy=new int[m+1];
        for(int i=0; i<n; i++){
            ps[i]=sc.nextInt();
            pt[i]=sc.nextInt();
        }
        System.out.println(solution());
    }
}
