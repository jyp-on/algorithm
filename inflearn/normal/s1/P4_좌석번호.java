package org.example.inflearn.normal.s1;
import java.util.*;
class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
public class P4_좌석번호 {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static int[] solution(int c, int r, int k){
        int[] answer = new int[2];
        Point[][] board = new Point[r][c];
        boolean[][] visited = new boolean[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                board[i][j] = new Point(j+1, 5-i);
            }
        }

        int cnt = 1;
        int blocking_cnt = 0;
        int y = r-1;
        int x = 0;
        int dir = 0;
        visited[r-1][0]=true; // (1,1) 자리

        while(true){
            // System.out.println(board[y][x].x + " " + board[y][x].y + " " + cnt);
            if(blocking_cnt==4) { // 4방면이 모두 막혔을 경우
                return answer;
            }
            if(cnt==k) {
                answer[0] = board[y][x].x;
                answer[1] = board[y][x].y;
                return answer;
            }
            int ny = y+dy[dir];
            int nx = x+dx[dir];
            if(ny<0 || ny>=r || nx<0 || nx>=c || visited[ny][nx]) {
                dir = (dir+1) % 4;
                blocking_cnt++;
            } else {
                visited[ny][nx] = true;
                y = ny;
                x = nx;
                cnt++;
                blocking_cnt=0;
            }
        }
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(6, 5, 12)));
        System.out.println(Arrays.toString(solution(6, 5, 20)));
        System.out.println(Arrays.toString(solution(6, 5, 30)));
        System.out.println(Arrays.toString(solution(6, 5, 31)));
    }
}
