import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};
    static int N, M;
    static int[][] board;
    static int[][] new_board;
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0);
        System.out.println(answer);
    }

    static void combi(int wallCnt) {
        if(wallCnt==3) { // 벽 세울 곳 3개를 골랐다면 바이러스 확산
            spread();
            answer = Math.max(answer, count());
            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(board[i][j]==0) {
                    board[i][j] = 1; // 빈공간을 벽으로
                    combi(wallCnt+1);
                    board[i][j] = 0; // 벽을 세웠던 공간을 다시 빈공간으로
                }
            }
        }
    }

    static void spread() {
        new_board = new int[N][M];
        for(int i=0; i<N; i++) {
            new_board[i] = board[i].clone();
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(board[i][j]==2) {
                    q.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];
            for (int j = 0; j < 4; j++) {
                int ny = cy + dy[j];
                int nx = cx + dx[j];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue; // 범위 밖
                if (new_board[ny][nx] == 0 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    new_board[ny][nx] = 2;
                    q.offer(new int[]{ny, nx});
                }
            }
        }
    }

    static int count() {
        int z_cnt=0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(new_board[i][j]==0) { // 안전지대의 수
                    z_cnt++;
                }
            }
        }
        return z_cnt;
    }
}