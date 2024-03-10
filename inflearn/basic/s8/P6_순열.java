package org.example.inflearn.basic.s8;

import java.util.Scanner;

public class P6_순열 {
    static int n, m;
    static int[] arr;
    public static void DFS(int L, int prev, String answer) {
        if(L==m){
            System.out.println(answer);
        }else{
            for(int i=0; i<n; i++){
                if(arr[i]!=prev) DFS(L+1, arr[i], answer+arr[i]+" ");
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        DFS(0,0,"");
    }
}
