package org.example.inflearn.basic.s8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
    int y, x;
    public Point(int y, int x){
        this.y=y;
        this.x=x;
    }
}

public class P11_미로최단거리 {
    static int[][] arr, dist = new int[8][8];
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] visited = new boolean[8][8];
    public static int BFS(int y, int x) {
        Queue<Point> Q = new LinkedList<>();
        visited[1][1]=true;
        Q.offer(new Point(y, x));
        int cnt=0;
        while(!Q.isEmpty()){
            Point p = Q.poll();
            System.out.println(p.y + " " + p.x);
            if(p.y==7 && p.x==7) return dist[7][7];
            for(int i=0; i<4; i++){
                int ny=p.y+dy[i];
                int nx=p.x+dx[i];
                if(ny>=1 && ny<=7 && nx>=1 && nx<=7){
                    if(!visited[ny][nx] && arr[ny][nx]==0){
                        visited[ny][nx]=true;
                        dist[ny][nx]=dist[p.y][p.x]+1;
                        Q.offer(new Point(ny, nx));
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=1; i<=7; i++){
            for(int j=1; j<=7; j++){
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println(BFS(1,1));
    }
}
