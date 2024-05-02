import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] board;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0, 0);
        System.out.println(min);
    }

    static void combi(int idx, int depth) {
        if(depth == N/2) {
            diff();
        } else {
            for(int i=idx; i<N; i++) {
                if(!visit[i]) {
                    visit[i] = true;
                    combi(i+1, depth+1);
                    visit[i] = false;
                }
            }
        }
    }

    static void diff() {
        int team1 = 0;
        int team2 = 0;

        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                if(visit[i] && visit[j]) {
                    team1 += board[i][j] + board[j][i];
                } else if(!visit[i] && !visit[j]) {
                    team2 += board[i][j] + board[j][i];
                }
            }
        }

        int res = Math.abs(team1 - team2);
        if(res==0) {
            System.out.println(0);
            System.exit(0);
        }
        min = Math.min(min, res);
    }
}