package org.example.inflearn.normal.s1;

import java.util.*;

public class P3_잃어버린강아지 {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static int solution(int[][] board){
        int time = 0;
        int dir1 = 0; // 사람 방향 
        int dir2 = 0; // 강아지 방향 
        int py = 0, px = 0; // 사람의 현재 좌표
        int oy = 0, ox = 0; // 강아지의 현재 좌표
        int rm = board.length;
        int cm = board[0].length;

        for(int i=0; i<rm; i++){
            for(int j=0; j<cm; j++){
                if(board[i][j]==2){
                    py=i;
                    px=j;
                }
                if(board[i][j]==3){
                    oy=i;
                    ox=j;
                }
            }
        }

        while(true){
//            System.out.println("사람 : " + py + " " + px + " 강아지 : " + oy + " " + ox + " time : " + time);
            if(py == oy && px == ox) return time;
            if(time>=10000) return 0;
            int pny = py + dy[dir1];
            int pnx = px + dx[dir1];
            int ony = oy + dy[dir2];
            int onx = ox + dx[dir2];


            if(pny<0 || pny>=rm || pnx<0 || pnx>=cm || board[pny][pnx]==1){ // 지도를 벗어나거나 장애물 만날 시 (사람)
                dir1 = (dir1+1) % 4;
            } else {
                py = pny;
                px = pnx;
            }

            if(ony<0 || ony>=rm || onx<0 || onx>=cm || board[ony][onx]==1){ // 지도를 벗어나거나 장애물 만날 시 (강아지)
                dir2 = (dir2+1) % 4;
            } else {
                oy = ony;
                ox = onx;
            }
            time++;
        }
    }

    public static void main(String[] args){
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(solution(arr2));
    }
}
