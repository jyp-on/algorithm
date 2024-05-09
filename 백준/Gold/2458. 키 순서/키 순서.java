import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean[][] check;
    static int[][] graph;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1];
        check = new boolean[n+1][n+1];
        count = new int[n+1];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            check[a][b] = true;
        }

        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(check[i][k] && check[k][j]) {
                        check[i][j] = true;
                    }
                }
            }
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(check[i][j] || check[j][i]) {
                    count[i]++;
                }
            }
        }

        int answer = 0;

        for(int i=1; i<=n; i++) {
//            System.out.print(count[i]+" ");
            if(count[i]==n-1) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
