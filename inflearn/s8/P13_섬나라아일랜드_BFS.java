package org.example.inflearn.s8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P13_섬나라아일랜드_BFS {
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0, 1, 1, -1, -1}; // 대각선 포함
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static Queue<Point> Q = new LinkedList<>();
    public static void BFS(int y, int x) {
        visited[y][x]=true;
        Q.offer(new Point(y, x));
        while(!Q.isEmpty()){
            Point p = Q.poll();
            for(int i=0; i<8; i++){
                int ny=p.y+dy[i];
                int nx=p.x+dx[i];
                if(ny>=0 && ny<n && nx>=0 && nx<n){
                    if(!visited[ny][nx] && arr[ny][nx]==1){
                        visited[ny][nx]=true;
                        Q.offer(new Point(ny, nx));
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr=new int[n][n];
        visited=new boolean[n][n]; // default false
        int answer=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j]=sc.nextInt();
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]==1 && !visited[i][j]){
                    BFS(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
