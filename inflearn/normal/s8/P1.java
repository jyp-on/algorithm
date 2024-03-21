package org.example.inflearn.normal.s8;

import java.util.*;
class P1 {
    public int solution(int n, int[][] flights, int s, int e, int k){
        int answer = 0;
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>(); // arr.get(0) -> 0에서 [0]까지 가는 비용 [1]
        for(int i = 0; i < n; i++) { // arr 초기화
            graph.add(new ArrayList<int[]>());
        }
        for(int[] x : flights) {
            graph.get(x[0]).add(new int[]{x[1], x[2]});
        }
        int[] dist = new int[n]; // i 까지 가는데 드는 최소 비용
        Arrays.fill(dist, Integer.MAX_VALUE); // max로 초기화
        dist[s] = 0; // 출발지점이므로 0
        // [0] 까지 오는데 드는 비용 [1]
        Queue<int[]> pQ = new LinkedList<>(); // 환승 횟수 순서대로 방문해야 하기 때문에 우선순위 큐 쓰면 안됨 (레벨 탐색)
        pQ.add(new int[]{s, 0});
        int L = 0;
        while(!pQ.isEmpty()) {
            int len = pQ.size();
            for(int i = 0; i < len; i++) {
                int[] cur = pQ.poll();
                int now = cur[0];
                int nowCost = cur[1];
                for(int[] x : graph.get(now)) {
                    int next = x[0];
                    int nextCost = x[1];
                    if(dist[next] > nowCost+nextCost) {
                        dist[next] = nowCost+nextCost;
                        pQ.offer(new int[]{next, dist[next]});
                    }
                }
            }
            L++;
            if(L>k) break;
        }
        return dist[e]==Integer.MAX_VALUE ? -1 : dist[e];
    }

    public static void main(String[] args){
        P1 T = new P1();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
        System.out.println(T.solution(4, new int[][]{{0, 3, 59},{2, 0, 83}, {3, 1, 16}, {1, 3, 16}}, 3, 0, 3));
    }
}
