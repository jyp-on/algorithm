package org.example.inflearn.normal.s1;
import java.util.*;

public class P2_청소 {
    static int[] dy = {0, 1, 0, -1};
    static int[] dx  = {1, 0, -1, 0};
    static int row_max;
    static int col_max;
    static int[] answer;
    static boolean flag=false;
    public static void DFS(int[][] board, int y, int x, int time, int direction, int k){
        if(flag) return;
        if(time==k){
            answer[0]=y;
            answer[1]=x;
            flag=true;
        }
        int ny = y + dy[direction];
        int nx = x + dx[direction];
//        System.out.println(y + " " + x);
        if(ny<0 || ny>=row_max || nx<0 || nx>=col_max || board[ny][nx]==1){ // 범위 외거나 장애물일경우
            DFS(board, y, x, time+1, (direction+1) % 4, k);
        } else {
            DFS(board, ny, nx, time+1, direction, k);
        }
    }
    public static int[] solution(int[][] board, int k){
        answer = new int[2]; // x, y
        row_max = board.length;
        col_max = board[0].length;
        DFS(board, 0, 0, 0, 0, k);
        return answer;
    }
    public static void main(String[] args){
//        int[][] arr1 = {{0, 0, 0, 0, 0},
//                {0, 1, 1, 0, 0},
//                {0, 0, 0, 0, 0},
//                {1, 0, 1, 0, 1},
//                {0, 0, 0, 0, 0}};
//        System.out.println(Arrays.toString(solution(arr1, 10)));
//        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
//                {0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 1},
//                {1, 1, 0, 0, 1, 0},
//                {0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0}};
//        System.out.println(Arrays.toString(solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(solution(arr3, 25)));
    }
}
