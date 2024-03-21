
package org.example.inflearn.normal.s7;

import java.util.*;
class P6 {

    public int solution(int[][] board){
        int answer = Integer.MAX_VALUE;
        int[] dy = {0, 0, -1, 1};
        int[] dx = {-1, 1, 0, 0};
        int r = board.length;
        int c = board[0].length;
        int[][] dist = new int[r][c]; // (영희 -> 딸기) + (기사 -> 딸기)

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(board[i][j]==2 || board[i][j]==3) {
                    Queue<int[]> Q = new LinkedList<>();
                    Q.add(new int[]{i, j});
                    int L = 0;
                    int[][] ch = new int[r][c];
                    while(!Q.isEmpty()) {
                        int len = Q.size();
                        for(int l = 0; l < len; l++) {
                            int[] p = Q.poll();
                            int y = p[0];
                            int x = p[1];
                            for(int k = 0; k < 4; k++) {
                                int ny = y + dy[k];
                                int nx = x + dx[k];
                                if(ny >= 0 && ny < r && nx >= 0 && nx < c) {
                                    if(ch[ny][nx] == 0 && board[ny][nx] != 1) {
                                        if(board[ny][nx] == 4) {
                                            dist[ny][nx] += L+1;
//                                            System.out.println(dist[ny][nx]);
                                        }
                                        ch[ny][nx] = 1;
                                        Q.offer(new int[]{ny, nx});
                                    }
                                }
                            }
                        }
                        L++;
                    }
                }
            }
        }

        for(int[] d : dist) {
            for(int x : d) if(x < answer && x > 0) answer = x;
        }

        return answer;
    }

    public static void main(String[] args){
        P6 T = new P6();
        System.out.println(T.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}}));
        System.out.println(T.solution(new int[][]{{4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}}));
    }
}
