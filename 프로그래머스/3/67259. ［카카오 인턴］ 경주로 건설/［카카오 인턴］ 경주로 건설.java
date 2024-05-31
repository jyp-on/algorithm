import java.util.*;
 
class Solution {
    int N;
    boolean[][][] visited;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    
    public int solution(int[][] board) {
        N = board.length;
        visited = new boolean[N][N][4]; // 방향에 대해서도 메모이제이션

        return bfs(board);
    }
    
    public int bfs(int[][] board) {
        int x=0, y=0, direction=-1, cost=0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, direction, cost));
        
        int min_cost = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.x == N-1 && cur.y == N-1) {
                min_cost = Math.min(min_cost, cur.cost);
                continue;
            }
            
            for(int dir=0; dir<4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
                if(board[nx][ny] == 1) continue;
                
                int nextCost = cur.cost;
                if(cur.dir == -1 || cur.dir == dir) {
                    nextCost += 100;
                } else {
                    nextCost += 600;
                }
                
                // 방문하지 않았거나 || cost가 더 적게 갱신된다면 방문
                if(!visited[nx][ny][dir] || board[nx][ny] >= nextCost) {
                    visited[nx][ny][dir] = true;
                    q.add(new Node(nx, ny, dir, nextCost));
                    board[nx][ny] = nextCost;
                }
            }
        }

        return min_cost;
    }

    public class Node {
        int x, y, dir, cost;

        public Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
}