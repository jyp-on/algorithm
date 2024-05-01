import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static void DFS(int depth, int start, String str) {
        if(depth == M) {
            System.out.println(str.replaceFirst(" ", ""));
        } else {
            for(int i = start; i <= N; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    DFS(depth + 1, i, str+" "+i);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        DFS(0, 1, "");


//        bw.write(answer.toString() + "\n");
//        bw.flush();
//        bw.close();
//        br.close();
    }

}