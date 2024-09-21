import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static char[][] board;
    static int answer = 0;
    static boolean[] visited;
    static int[] selected = new int[7];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new char[5][5];
        for (int i = 0; i < 5; i++) {
            board[i] = br.readLine().toCharArray();
        }

        combi(0, 0, 0);
        System.out.println(answer);
    }

    static void combi(int depth, int numY, int start) {
        // 임다연파가 4명 이상인 경우 Back
        if (numY >= 4) return;

        if (depth == 7) {
            visited = new boolean[7];
            BFS();
            return;
        }

        for (int i = start; i < 25; i++) {
            selected[depth] = i;
            if (board[i/5][i%5] == 'Y') {
                combi(depth+1, numY+1, i+1);
            } else {
                combi(depth+1, numY, i+1);
            }
        }
    }

    static void BFS() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {selected[0]/5, selected[0]%5});
        visited[0] = true;
        int conn = 1; // 연결 몇개 되어있는지

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                int ni = nr*5 + nc; // selected index 로 치환

                if (!isValid(nr, nc)) continue;

                for (int k = 0; k < 7; k++) {
                    // 방문하지 않고 selected 중에 연결된게 있다면
                    if (!visited[k] && selected[k] == ni) {
                        visited[k] = true;
                        q.offer(new int[] {nr, nc});
                        conn++;
                    }
                }
            }
        }

        if (conn == 7) answer++;
    }

    static boolean isValid(int r, int c) {
        if (r >= 0 && r < 5 && c >= 0 && c < 5) return true;
        return false;
    }
}