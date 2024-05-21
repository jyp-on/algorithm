import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int to, cost;
    Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static int n, m;
    static List<List<Node>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        System.out.println(dijkstra(start, end));
    }

    static int dijkstra(int start, int end) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0}); // start 까지 0만큼의 최소 비용이 든다.

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cur_loc = cur[0];
            int cur_cost = cur[1];
            if(dist[cur_loc] < cur_cost) continue;

            for(Node next : graph.get(cur_loc)) {
                if(cur_cost + next.cost < dist[next.to]) {
                    dist[next.to] = cur_cost + next.cost;
                    pq.offer(new int[]{next.to, dist[next.to]});
                }
            }
        }


        return dist[end];
    }
}