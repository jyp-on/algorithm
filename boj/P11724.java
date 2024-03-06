package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11724 {
    static ArrayList<Integer>[] A; // 인접 리스트 저장 배열
    static boolean visited[]; // 방문기록 저장 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노드 개수
        int m = Integer.parseInt(st.nextToken()); // 에지 개수
        A = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {   // 인접 리스트 초기화하기
            A[i] = new ArrayList<Integer>(); 
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e); // 양방향 에지이므로 양쪽에 에지 더하기
            A[e].add(s);
        }

        int count = 0;

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    static void DFS(int v) {
        if (visited[v]) return;
        visited[v] = true;

        for (int o : A[v]) {
            if (!visited[o]) DFS(o);
        }
    }
}
