import java.util.*;

class Solution {
    static int n, m;
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        int answer = 0;
        
        for(int i=0; i<n; i++) {
            String map = maps[i];
            for(int j=0; j<m; j++) {
                if(map.charAt(j) == 'S' || map.charAt(j) == 'E') {
                    int dist = bfs(i, j, maps);
                    if(dist == -1)
                        return -1;
                    else
                        answer += dist;
                }
            }
        }
        
        return answer;
    }
    
    int bfs(int r, int c, String[] maps) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        boolean[][] visit = new boolean[n][m];
        visit[r][c] = true;
        
        int cnt = 0;
        
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i=0; i<len; i++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                for(int j=0; j<4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                    if(visit[nx][ny]) continue;
                    if(maps[nx].charAt(ny) == 'X') continue;
                    if(maps[nx].charAt(ny) == 'L') {
                        return cnt+1;
                    }
                    
                    visit[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
            cnt++;
        }
        
        return -1;
    }
}