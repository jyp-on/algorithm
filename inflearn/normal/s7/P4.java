package org.example.inflearn.normal.s7;

import java.util.*;
class P4 {
    int[] dy = {0, 0, -1, 1};
    int[] dx = {-1, 1, 0, 0};
    public int solution(int[][] board){
        int L = 0;
        int[][] ch = new int[7][7];
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0, 0});
        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i = 0; i < len; i++) {
                int[] point = Q.poll();
//                System.out.println(point[0] + " " + point[1]);
                for(int j = 0; j < 4; j++) {
                    int ny = point[0] + dy[j];
                    int nx = point[1] + dx[j];
                    if(ny == 6 && nx == 6) return L+1;
                    if(ny >= 0 && ny < 7 && nx >= 0 && nx < 7 && board[ny][nx] == 0) { // 갈 수 있는 길이면
                        if(ch[ny][nx] == 0) {
                            ch[ny][nx] = 1;
                            Q.offer(new int[]{ny, nx});
                        }
                    }
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args){
        P4 T = new P4();
        System.out.println(T.solution(new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}
        }));
        System.out.println(T.solution(new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0}
        }));
    }
}

