import java.util.*;
class Solution {
    // 시작점은 도착점일 수 없음
    public int nearestExit(char[][] maze, int[] entrance) {
        int r_s = maze.length;
        int c_s = maze[0].length;
        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[r_s][c_s];
        int ent_r = entrance[0], ent_c = entrance[1];
        q.add(new int[]{ent_r, ent_c});
        visited[ent_r][ent_c] = true;
        
        int cnt = 0;
        while(!q.isEmpty()) {
            cnt++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for(int j = 0; j < 4; j++) {
                    int nr = cur[0] + dr[j];
                    int nc = cur[1] + dc[j];
                    if(nr<0 || nr>=r_s || nc<0 || nc>=c_s) continue;
                    if(visited[nr][nc]) continue;
                    if(maze[nr][nc]=='+') continue;
                    if(nr==r_s-1 || nr==0 || nc==c_s-1 || nc==0) { // 벽 끝쪽인 경우
                        if(!(nr==ent_r && nc==ent_c)) { // 시작점이 아닌 경우
                            return cnt;
                        }
                    }
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return -1;
    }
}