package org.example.inflearn.normal.s8;

import java.util.*;
class P3 {

    public int solution(int[][] board) { // 다익스트라
        int answer = 0;
        int[] dy = {0, -1, 0, 1}; // 지도상으로 오른쪽, 아래가 먼저 나오도록
        int[] dx = {1, 0, -1, 0};
        int row = board.length;
        int col = board[0].length;
        // [0, 0] 까지 오는데 드는 비용 [1]
        int[][] dist = new int[row][col];
        for(int i = 0; i < row; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a , b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        while(!pq.isEmpty()) {
            int[] cur = pq.poll(); // 현재 위치
            int y = cur[0];
            int x = cur[1];
            int nowCost = cur[2];
            if(dist[y][x] < nowCost) continue; // y, x까지 가는 비용이 기존보다 크면 볼필요 없음
            for(int j = 0; j < 4; j++) {
                int ny = y + dy[j];
                int nx = x + dx[j];
                if(ny >= 0 && ny < row && nx >= 0 && nx < col) {
                    int nextCost;
                    if(board[ny][nx] == 0) nextCost = nowCost + 0;
                    else nextCost = nowCost + 1;
                    if(dist[ny][nx] > nextCost) {
                        dist[ny][nx] = nextCost;
                        pq.offer(new int[]{ny, nx, dist[ny][nx]});
                    }
                }
            }
        }
//
//        for(int[] line : dist) {
//            for(int x : line) {
//                System.out.print(x + " ");
//            }
//            System.out.println();
//        }
//        for(int r = 0; r < row; r++) {
//            for(int c = 0; c < col; c++) {
//
//            }
//        }

        return dist[row-1][col-1];
    }

    public static void main(String[] args){
        P3 T = new P3();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}