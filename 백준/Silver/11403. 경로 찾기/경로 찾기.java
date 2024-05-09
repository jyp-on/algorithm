import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=0; k<n; k++) { // 중간 노드
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(graph[i][k]==1 && graph[k][j]==1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
