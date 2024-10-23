import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] visited;
    static char[][] board;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        int cnt1 = 0, cnt2 = 0;
        board = new char[N][N];
        for(int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    dfs(i, j, board[i][j]);
                    cnt1++;
                }
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j]=='G') board[i][j]='R';
            }
        }
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    dfs(i, j, board[i][j]);
                    cnt2++;
                }
            }
        }

        System.out.println(cnt1 + " " + cnt2);
    }

    public static void dfs(int x, int y, char t) {
        for(int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
            if(board[nx][ny] != t) continue;
            if(visited[nx][ny]) continue;
            visited[nx][ny] = true;
            dfs(nx, ny, t);
        }

    }
}