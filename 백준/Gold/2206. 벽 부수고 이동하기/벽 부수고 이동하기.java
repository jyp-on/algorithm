import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // NxM 맵 행렬 생성 (1과 0이 값으로 들어옴)
        map = new int[n][m];
        for (int i = 0; i < map.length; i++) {
            String str = br.readLine();
            for (int j = 0; j < map[i].length; j++) {
                int num = str.charAt(j) - '0';
                if (num == 1) {
                    map[i][j] = num;
                }
            }
        }
        // 출발지와 목적지가 같을 경우
        if (n == 1 && m == 1) {
            System.out.println(1);
            System.exit(0);
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        // 방문을 체크하는 3차원 배열
        int[][][] check = new int[2][n][m];
        // [0, n, m] : 벽 안부수고 지나가는 방문노드 경로
        // [1, n, m] : 벽 부수고 지나가는 방문노드 경로

        // 동서남북
        int[] dy = { 0, 0, -1, 1 };
        int[] dx = { -1, 1, 0, 0 };

        Queue<int[]> q = new LinkedList<>();
        // 시작 노드를 q에 담기
        q.offer(new int[] { 0, 0, 0 });
        // 벽 안부쉈으니까 {0, 0, 0}에 지나온 칸의 개수 1을 값으로 넣기.
        check[0][0][0] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int w = cur[0];
            int y = cur[1];
            int x = cur[2];
            for(int i=0; i<4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny<0 || ny>=n || nx<0 || nx>=m) continue;

                // 벽이 아닌 경우
                if(map[ny][nx]==0) {
                    if(check[w][ny][nx]==0) { // 방문한적 없다면
                        check[w][ny][nx] = check[w][y][x] + 1;
                        q.offer(new int[]{w, ny, nx});
                        if(ny==n-1 && nx==m-1)
                            return check[w][ny][nx];
                    }
                } else { // 벽인 경우
                    if(w==0) { // 직전 노드까지 벽을 안부쉈으면
                        check[1][ny][nx] = check[0][y][x] + 1;
                        q.offer(new int[]{1, ny, nx}); // 벽을 부쉈으니 다음엔 못부시도록 1로 출발
                        if(ny==n-1 && nx==m-1)
                            return check[1][ny][nx];
                    }
                }
            }
        }

        return -1;

    }

}
