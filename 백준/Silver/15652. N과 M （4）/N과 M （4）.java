import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static void DFS(int depth, int prev) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
        } else {
            for(int i = prev; i <= N; i++) {
                arr[depth] = i;
                DFS(depth + 1, i);
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

//        visited = new boolean[N + 1];
        arr = new int[M];
        DFS(0, 1);
        System.out.println(sb.toString());

//        bw.write(answer.toString() + "\n");
//        bw.flush();
//        bw.close();
//        br.close();
    }

}