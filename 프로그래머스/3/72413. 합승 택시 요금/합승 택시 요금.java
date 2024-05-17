import java.util.*;
class Solution {
    static int INF = Integer.MAX_VALUE;
    static int[][] map;
    static int N;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        N = n;
        map = new int[n+1][n+1];
        for(int i=0; i<fares.length; i++) {
            int c = fares[i][0];
            int d = fares[i][1];
            int f = fares[i][2];
            map[c][d] = f;
            map[d][c] = f;
        }
        
        int[] together = dijkstra(s);
        int[] start_A = dijkstra(a);
        int[] start_B = dijkstra(b);
        
        int answer = Integer.MAX_VALUE;
        
        for(int i=1; i<=N; i++) {
            answer = Math.min(answer, together[i] + start_A[i] + start_B[i]);
        }
        
        return answer;
    }
    
    int[] dijkstra(int start) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        // ~~까지 가는데, 드는 비용
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int now_cost = cur[1];
            if(now_cost > dist[now]) continue;
            for(int v=1; v<=N; v++) {
                if(map[now][v]==0)
                    continue;
                
                if(dist[now] + map[now][v] < dist[v]) {
                    dist[v] = dist[now] + map[now][v];
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        
        return dist;
    }
}