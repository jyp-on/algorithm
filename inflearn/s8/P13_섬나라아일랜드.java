package org.example.inflearn.s8;

import java.util.Scanner;

public class P13_섬나라아일랜드 {
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0, 1, 1, -1, -1}; // 대각선 포함
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    public static void DFS(int y, int x) {
        for(int i=0; i<8; i++){
            int ny=y+dy[i];
            int nx=x+dx[i];
            if(ny>=0 && ny<n && nx>=0 && nx<n){
                if(!visited[ny][nx] && arr[ny][nx]==1){
                    visited[ny][nx]=true;
                    DFS(ny,nx);
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
                if(!visited[i][j] && arr[i][j]==1){
                    visited[i][j]=true;
                    DFS(i, j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
