package org.example.inflearn.s7;

public class P6_부분집합 {
    static int n;
    static int[] ch;
    public static void dfs(int L) {
        if(L==n+1) {
            for(int i=1; i<=n; i++) {
                if (ch[i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        } else {
            ch[L]=1;
            dfs(L+1);
            ch[L]=0;
            dfs(L+1);
        }
    }
    public static void main(String[] args) {
        n=3;
        ch=new int[n+1];
        dfs(1);
    }
}
