package org.example.inflearn.normal.s7;

import java.util.*;
class P5 {
    int[] dy = {0, 0, -1, 1};
    int[] dx = {-1, 1, 0, 0};
    public int solution(int[][] board){
        int answer = 0;
        int emptyRand = 0;
        int n = board.length;
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 1) {
                    answer = Integer.MAX_VALUE;
                    Queue<int[]> Q = new LinkedList<>();
                    Q.offer(new int[]{i, j});
                    int L = 1;
                    while(!Q.isEmpty()) {
                        int len = Q.size();
                        for(int k = 0; k < len; k++) {
                            int[] p = Q.poll();
                            for(int l = 0; l < 4; l++) {
                                int ny = p[0] + dy[l];
                                int nx = p[1] + dx[l];
                                if(ny < n && ny >= 0 && nx < n && nx >= 0) {
                                    if(board[ny][nx] == emptyRand) {
                                        board[ny][nx]--;
                                        dist[ny][nx] += L;
                                        Q.offer(new int[]{ny, nx});
                                        answer = Math.min(answer, dist[ny][nx]);
                                    }
                                }
                            }
                        }
                        L++;
                    }
                    emptyRand--;
                }
            }
        }

//        for(int[] line : dist) {
//            for(int x : line) System.out.print(x + " ");
//            System.out.println();
//        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args){
        P5 T = new P5();
        System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}
