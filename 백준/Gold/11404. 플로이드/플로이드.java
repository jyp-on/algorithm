import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int INF = 100001*99;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] graph = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) graph[i][j] = 0;
                else graph[i][j] = INF;
            }
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = Math.min(graph[a][b], c);
        }

        // 경유지
        for(int k = 1; k <= n; k++) {
            // 출발지
            for(int i = 1; i <= n; i++) {
                // 도착지
                for(int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }


        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(graph[i][j] == INF) System.out.print(0 + " ");
                else System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void print(int[][] graph) {
        System.out.println();
        for(int[] g : graph) {
            for(int x : g) System.out.print(x + " ");
            System.out.println();
        }
    }


}
