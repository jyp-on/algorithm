
package org.example.inflearn.normal.s4;

import java.util.*;
class P5 {
    public int solution(int[][] board){
        int answer=0;
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        int cnt = 0;
        for(int i=0; i<board.length; i++){ // row
            for(int j=0; j<board[0].length; j++){ // col
                if(board[i][j]==1) {
                    row.add(i);
                    col.add(j);
                    cnt++;
                }
            }
        }
        Collections.sort(row);
        Collections.sort(col);
        int mid = cnt/2; // 중앙
        int row_m = row.get(mid);
        int col_m = col.get(mid);
        for(int i=0; i<col.size(); i++){
            answer += Math.abs(col_m - col.get(i));
        }
        for(int i=0; i<row.size(); i++){
            answer += Math.abs(row_m - row.get(i));
        }
        return answer;
    }

    public static void main(String[] args){
        P5 T = new P5();
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }
}