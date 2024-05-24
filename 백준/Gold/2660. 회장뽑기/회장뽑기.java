import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    arr[i][j] = INF;
                }
            }
        }

        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1) break;
            arr[a][b] = arr[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int readerScore = INF;
        int[] scoreArr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int score = 0;
            for (int j = 1; j <= n; j++) {
                if(arr[i][j]==INF) continue;
                score = Math.max(score, arr[i][j]);
            }
            scoreArr[i] = score;
            readerScore = Math.min(readerScore, score);
        }

        int hubo_cnt = 0;

        for(int i=1; i<=n; i++) {
            if(scoreArr[i]==readerScore) {
                hubo_cnt++;
            }
        }

        System.out.println(readerScore + " " + hubo_cnt);

        for(int i=1; i<=n; i++) {
            if(scoreArr[i]==readerScore) {
                System.out.print(i+" ");
            }
        }
    }
}