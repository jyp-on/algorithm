import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] visited;
    static int[][] board;
    static int N, M, maxSize, cnt;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    int size = spread(i, j);
                    maxSize = Math.max(maxSize, size);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(maxSize);
    }

    private static int spread(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = true;
        q.add(new int[]{r, c});
        int size = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int k = 0; k < 4; k++) {

                int nr = cur[0] + dr[k];
                int nc = cur[1] + dc[k];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M
                    && !visited[nr][nc] && board[nr][nc] == 1) {

                    visited[nr][nc] = true;
                    size++;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return size;
    }
}