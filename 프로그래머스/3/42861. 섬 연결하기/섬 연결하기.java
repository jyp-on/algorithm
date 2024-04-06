import java.util.*;
class Solution {
    
    public static ArrayList<Edge> edgeList;
    public static int[] unf;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        edgeList = new ArrayList<>();
        for(int[] cost : costs) {
            edgeList.add(new Edge(cost[0], cost[1], cost[2]));
        }
        Collections.sort(edgeList);
        unf = new int[n];
        for(int i = 0; i < n; i++) { // unf 초기화
            unf[i] = i;
        }
        for(int i = 0; i < edgeList.size(); i++) { // kruskal
            Edge edge = edgeList.get(i);
            if(!isSameParent(edge.v1, edge.v2)) { // 부모가 다르면 연결
                answer += edge.cost;
                union(edge.v1, edge.v2);
            }
        }
        
        return answer;
    }
    
    public static boolean isSameParent(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa == fb) return true;
        else return false;
    }
    
    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa] = fb;
    }
    
    public static int find(int v) {
        if(unf[v] == v) return unf[v];
        else return unf[v] = find(unf[v]); // 경로 압축
    }
    
    class Edge implements Comparable<Edge>{
        int v1;
        int v2;
        int cost;
        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
        public int compareTo(Edge o) {
            return this.cost - o.cost; // 비용 오름차순
        }
    }
}