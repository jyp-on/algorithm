package org.example.graph;

import java.util.Scanner;

public class P1717_집합표현하기 {
    // 유니온 파인드
    public static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 원소 개수
        int M = sc.nextInt(); // 질의 개수
        parent = new int[N+1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int question = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (question == 0) {
                union(a, b);
            } else {
                if (checkSame(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static void union(int a, int b) { // 대표 노드끼리 연결
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) {
        if (a == parent[a]) return a;
        else return parent[a] = find(parent[a]); // 경로 압축
    }

    public static boolean checkSame(int a, int b) { // 두 원소가 같은 집합인지 확인
        a = find(a);
        b = find(b);
        return a == b;
    }
}
