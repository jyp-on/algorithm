package org.example.inflearn.normal.s1;

import java.util.*;

public class P7_비밀번호 {
    static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};

    public static int solution(int[] keypad, String password){
        int answer = 0;
        int[][] dist = new int[10][10];
        int[][] pad = new int[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                pad[i][j] = keypad[i*3 + j];
            }
        }
        for(int i=0; i<10; i++) Arrays.fill(dist[i], 2);
        for(int i=0; i<10; i++) dist[i][i]=0;
        // pad 탐색
        for(int i=0; i<3; i++){ // 행
            for(int j=0; j<3; j++){ // 열
                int from=pad[i][j];
                for(int k=0; k<8; k++){
                    if(i+dy[k]>=0 && i+dy[k]<3 && j+dx[k]>=0 && j+dx[k]<3){
                        int to = pad[i+dy[k]][j+dx[k]];
                        dist[from][to]=1;
                    }
                }
            }
        }
        for(int i=1; i<password.length(); i++){
            int from = password.charAt(i-1)-48;
            int to = password.charAt(i)-48;
            answer += dist[from][to];
        }

        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}
