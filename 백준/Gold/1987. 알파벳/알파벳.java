import java.io.*;
import java.util.*;

public class Main {

    static int R, C, answer;
    static char[][] board;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        visit = new boolean[R][C];
        answer = 0;

        for(int i=0; i<R; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j=0; j<C; j++) {
                board[i][j] = arr[j];
            }
        }

        Set<Character> set = new HashSet<>();
        set.add(board[0][0]);
        DFS(0, 0, 1, set);
        System.out.println(answer);
    }

    static void DFS(int r, int c, int cnt, Set<Character> set) {
        answer = Math.max(answer, cnt);

        for(int i=0; i<4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if(set.contains(board[nr][nc])) continue;
            if(visit[nr][nc]) continue;

            set.add(board[nr][nc]);
            visit[nr][nc] = true;
            DFS(nr, nc, cnt+1, set);
            visit[nr][nc] = false;
            set.remove(board[nr][nc]);
        }
    }
}