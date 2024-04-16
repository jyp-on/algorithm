import java.util.*;

class Solution {
    class Edge implements Comparable<Edge> {
        int to, cost; // to까지 가는데 드는 cost
        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge ob) {
            return this.cost - ob.cost;
        }
    }
    public int solution(int N, int[][] road, int K) {
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        int[] dist = new int[N+1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] r : road) {
            int from = r[0];
            int to = r[1];
            int cost = r[2];
            graph.get(from).add(new Edge(to, cost));
            graph.get(to).add(new Edge(from, cost));
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));
        
        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            
            for(Edge ne : graph.get(e.to)) { // e와 연결된 노드들
                if(dist[ne.to] > dist[e.to] + ne.cost) {
                    dist[ne.to] = dist[e.to] + ne.cost;
                    pq.offer(ne);
                }
            }
        }
        
        int answer = 0;
        for(int d : dist) {
            if(d <= K) answer++;
        }
        return answer;
    }
    
}