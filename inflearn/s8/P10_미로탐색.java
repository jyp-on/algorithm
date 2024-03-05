package org.example.inflearn.s8;

import java.util.Scanner;

public class P10_미로탐색 {
    static int[][] arr = new int[8][8];
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] visited = new boolean[8][8];
    static int answer=0;
    public static void DFS(int y, int x) {
        if(y==7 && x==7) {
            answer++;
        }
        else{
            for(int i=0; i<4; i++){
                int ny=y+dy[i];
                int nx=x+dx[i];
                if(ny>=1 && ny<=7 && nx>=1 && nx<=7){
                    if(!visited[ny][nx] && arr[ny][nx]==0){
                        visited[ny][nx]=true;
                        DFS(ny, nx);
                        visited[ny][nx]=false;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=1; i<=7; i++){
            for(int j=1; j<=7; j++){
                arr[i][j]=sc.nextInt();
            }
        }
        visited[1][1]=true;
        DFS(1,1);
        System.out.println(answer);
    }
}
