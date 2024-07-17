import java.util.*;

class Solution {
    int[] dy = {1, -1, 0, 0};
    int[] dx = {0, 0, 1, -1};
    public int solution(String[] board) {
        int row_size = board.length;
        int col_size = board[0].length();
        int[] start = new int[2];
        int[] end = new int[2];
        
        for(int i=0; i<row_size; i++) {
            for(int j=0; j<col_size; j++) {
                if(board[i].charAt(j) == 'R') {
                    start[0] = i;
                    start[1] = j;
                }
                else if(board[i].charAt(j) == 'G') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        
        // 중복방문을 피하기 위해 방문처리
        boolean[][] visited = new boolean[row_size][col_size];
        visited[start[0]][start[1]] = true;
        
        int cnt = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] cur = q.poll();
                // 방향
                for(int j=0; j<4; j++) {
                    // 전역으로 변수 잡기위해 초반에 ny, nx를 만들어 둠
                    int ny = cur[0] + dy[j];
                    int nx = cur[1] + dx[j];
                    
                    // 한방향으로 쭉. (장애물 만나거나 맵 밖으로 나갈 때 까지)
                    while(true) {
                        if(ny < 0 || ny >= row_size || nx < 0 || nx >= col_size
                           || board[ny].charAt(nx) == 'D') {
                            
                            ny -= dy[j];
                            nx -= dx[j];
                            break;
                        } else {
                            ny += dy[j];
                            nx += dx[j];
                        }
                    }
                    
                    // 슬라이딩 한 곳이 목표지점이면 cnt + 1 return
                    if(ny == end[0] && nx == end[1]) {
                        return cnt+1;
                    }
                    
                    if(!visited[ny][nx]) {
                        visited[ny][nx] = true;
                        q.offer(new int[]{ny, nx});
                    }
                }
            }
            cnt ++;
        }
        
        return -1;
    }
}