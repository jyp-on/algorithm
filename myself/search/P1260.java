package org.example.myself.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1260 {
    static ArrayList<Integer>[] A; // 인접 리스트 저장 배열
    static boolean visited[]; // 방문기록 저장 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노드 개수
        int m = Integer.parseInt(st.nextToken()); // 에지 개수
        int start = Integer.parseInt(st.nextToken()); // 시작 노드
        A = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {   // 인접 리스트 초기화하기
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) { // 에지의 개수만큼 반복
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e); // 양방향 에지이므로 양쪽에 에지 더하기
            A[e].add(s);
        }

        for (int i = 1; i <= n; i++) { // 번호가 작은것부터 방문하기 위해 정렬
            Collections.sort(A[i]);
        }

        visited = new boolean[n + 1]; // 방문배열 초기화
        DFS(start);

        System.out.println();
        visited = new boolean[n + 1]; // 방문배열 초기화
        BFS(start);
    }

    static void DFS(int v) {
        if (visited[v]) return;

        System.out.print(v + " ");
        visited[v] = true;

        for (int o : A[v]) {
            if (!visited[o]) DFS(o);
        }
    }

    static void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v); // 시작 노드 삽입
        visited[v] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            for (int o : A[node]) {
                if (!visited[o]) {
                    visited[o] = true;
                    q.add(o);
                }
            }
        }
    }
}
