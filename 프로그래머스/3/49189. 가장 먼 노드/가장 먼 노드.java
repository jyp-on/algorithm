import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) { // 0번은 사용안함
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        Queue<Integer> Q = new LinkedList<>();
        Q.add(1); // 1번 노드부터 시작
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        int[] dist = new int[n+1];
        while(!Q.isEmpty()) {
            int cur_n = Q.poll();
            for(int next : graph.get(cur_n)) {
                if(!visited[next]) {
                    Q.add(next);
                    visited[next] = true;
                    dist[next] = dist[cur_n]+1;
                }
            }
        }
        int answer = 0;
        Arrays.sort(dist);
        int max = dist[dist.length-1];
        for(int d : dist) {
            if(d == max) answer++;
        }
        return answer;
    }
}