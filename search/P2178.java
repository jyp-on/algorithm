package org.example.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {

    //상하좌우 탐색하기 위한 배열
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visited;
    static int[][] A;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }

        BFS(0, 0);
        System.out.println(A[N-1][M-1]);
    }

    static void BFS(int i, int j) {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            printMap();
            int[] now = queue.poll();
            for (int k = 0; k < 4; k++) { // 상하좌우 탐색
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x >= 0 && x < N && y >= 0 && y < M) { // 좌표 유효성 검사
                    if (!visited[x][y] && A[x][y] != 0) { // 방문했는지, 0이 아닌지 검사
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1; // 이전 좌표에서 1 더한값으로 업데이트
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }
    }

    static void printMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println("\n");
        }
        System.out.print("------------------------\n");
    }
}
