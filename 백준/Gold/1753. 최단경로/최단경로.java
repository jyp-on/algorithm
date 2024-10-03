import java.util.*;
import java.io.*;
import java.math.*;

class Node implements Comparable<Node>{
    int vertex;
    int weight;

    Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    public int compareTo(Node other) {
        return this.weight - other.weight;
    }
}

public class Main {

    static int V, E, S;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(br.readLine());
        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[S] = 0;

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 3; j++) {
                graph.get(u).add(new Node(v, w));
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(S, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            // 현재 지점까지의 최소 가중치와 현재까지 온 비용 비교
            if (cur.weight > dist[cur.vertex]) continue;
            for (Node n : graph.get(cur.vertex)) {
                if (dist[n.vertex] > dist[cur.vertex] + n.weight) {
                    dist[n.vertex] = dist[cur.vertex] + n.weight;
                    pq.offer(new Node(n.vertex, dist[n.vertex]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) sb.append("INF\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.println(sb);
    }
}