package org.example.inflearn.basic.s7;

import java.util.ArrayList;
import java.util.Scanner;

public class P10_경로탐색_인접리스트 {
    // 2차원 배열로 하면 메모리가 N*N만큼 잡히며, 갈 수 있는 정점을 확인하려면 N만큼 확인해야 함.
    static int n, m, answer=0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    public static void DFS(int v) {
        if(v==n) answer++;
        else {
            for(int x : graph.get(v)) {
                if(ch[x]==0) {
                    ch[x]=1;
                    DFS(x);
                    ch[x]=0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 정점 수
        m = sc.nextInt(); // 간선 수
        graph = new ArrayList<ArrayList<Integer>>();
        ch=new int[n+1];
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0; i<m; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            graph.get(a).add(b);
        }

//        for(ArrayList<Integer> x: graph) {
//            System.out.println(x);
//        }
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