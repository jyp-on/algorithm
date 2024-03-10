package org.example.inflearn.basic.s7;

import java.util.Scanner;

public class P10_경로탐색_인접행렬 {
    static int n, m, answer=0;
    static int[][] graph;
    static int[] ch;
    public static void DFS(int v) {
        if(v==n) answer++;
        else {
            for(int i=1; i<=n; i++) {
                if(graph[v][i]==1 && ch[i]==0) {
                    ch[i]=1;
                    DFS(i);
                    ch[i]=0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 정점 수
        m = sc.nextInt(); // 간선 수
        graph=new int[n+1][m+1];
        ch=new int[n+1];
        for(int i=0; i<m; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            graph[a][b]=1;
        }
        ch[1]=1;
        DFS(1);
        System.out.println(answer);
    }
}

/** input
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5
 */