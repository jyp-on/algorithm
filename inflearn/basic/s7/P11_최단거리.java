package org.example.inflearn.basic.s7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P11_최단거리 {
    static int n, m = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited, dis;
    public static int BFS(int v) {
        visited=new int[n+1];
        dis=new int[n+1];

        visited[v]=1;

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(1);
        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i=0; i<len; i++) {
                int p = Q.poll();
                for(int x : graph.get(p)) {
                    if(visited[x]==0) {
                        visited[x]=1; // 방문처리
                        dis[x]=dis[p]+1;
                        Q.offer(x);
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 정점 수
        m = sc.nextInt(); // 간선 수
        graph = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0; i<m; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            graph.get(a).add(b);
        }
        BFS(1);
        for(int i=2; i<=n; i++) {
            System.out.println(i + " : " +dis[i]);
        }
    }
}

/** input
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5
 */