package org.example.inflearn.s8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P12_토마토 {
    static int n,m;
    static int[][] arr, dist;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static Queue<Point> Q = new LinkedList<>();
    public static void BFS() {
        while(!Q.isEmpty()){
            Point p = Q.poll();
            for(int i=0; i<4; i++){
                int ny=p.y+dy[i];
                int nx=p.x+dx[i];
                if(ny>=0 && ny<m && nx>=0 && nx<n){
                    if(arr[ny][nx]==0){
                        arr[ny][nx]=1;
                        dist[ny][nx]=dist[p.y][p.x]+1;
                        Q.offer(new Point(ny, nx));
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr=new int[m][n];
        dist=new int[m][n];
        int answer=0;
        for(int i=0;i<m; i++){
            for(int j=0; j<n; j++){
                int v=sc.nextInt();
                if(v==1) Q.offer(new Point(i, j));
                arr[i][j]=v;
            }
        }
        BFS();
        boolean flag = true; // 토마토가 다 익었는지
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]==0) {
                    flag = false;
                }
            }
        }
        if(flag) { // 다 익었다면
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    answer=Math.max(answer, dist[i][j]);
                }
            }
            System.out.println(answer);
        } else{
            System.out.println(-1);
        }
    }
}
