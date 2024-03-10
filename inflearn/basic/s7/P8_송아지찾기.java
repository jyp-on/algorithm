package org.example.inflearn.basic.s7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P8_송아지찾기 {
    static int[] dist={1,-1,5};
    static boolean[] visited;
    static Queue<Integer> Q = new LinkedList<>();

    public static int BFS(int s, int e) {
        visited = new boolean[100001];
        visited[s] = true;
        Q.offer(s);
        int L=0;

        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i=0; i<len; i++) {
                int x = Q.poll();
                for(int d : dist) {
                    int nx = x+d;
                    if(nx==e) return L+1;
                    if(nx>=1 && nx<=10000 && !visited[nx]) {
                        Q.offer(nx);
                        visited[nx]=true;
                    }
                }
            }
            L++;
        }

        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(BFS(s, e));
    }
}
