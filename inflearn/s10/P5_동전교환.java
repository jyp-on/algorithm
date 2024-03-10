package org.example.inflearn.s10;

import java.util.*;

public class P5_동전교환 {
    static int n, m;
    static int[] coin, dy;
    public static int solution(){
        int answer=0;
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0]=0;
        for(int i=0; i<n; i++){
            for(int j=coin[i]; j<=m; j++){
                if(dy[j] > dy[j-coin[i]]+1){
                    dy[j] = dy[j-coin[i]]+1;
                }
            }
        }
        answer=dy[m];
        return answer;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        coin=new int[n];
        for(int i=0; i<n; i++){
            coin[i]=sc.nextInt();
        }
        m=sc.nextInt();
        dy=new int[m+1];
        System.out.println(solution());
    }
}
