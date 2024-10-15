import java.util.*;
class Solution {
    // 시작점은 도착점일 수 없음
    public int nearestExit(char[][] maze, int[] entrance) {
        int r_s = maze.length;
        int c_s = maze[0].length;

        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        Queue<int[]> q = new LinkedList<>();
        int ent_r = entrance[0], ent_c = entrance[1];
        q.add(new int[]{ent_r, ent_c, 0});
        maze[ent_r][ent_c] = '+';
        
        int cnt = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int j = 0; j < 4; j++) {
                int nr = cur[0] + dr[j];
                int nc = cur[1] + dc[j];
                if(nr<0 || nr>=r_s || nc<0 || nc>=c_s) continue;
                if(maze[nr][nc]=='+') continue;
                if(nr==r_s-1 || nr==0 || nc==c_s-1 || nc==0) { // 벽 끝쪽인 경우
                    return cur[2] + 1;
                }
                maze[nr][nc] = '+';
                q.add(new int[]{nr, nc, cur[2]+1});
            }
            
        }
        return -1;
    }
}