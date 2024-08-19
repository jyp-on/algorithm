import java.util.*;
public class Main {
    static int N, M;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N + 1];
        int[] out = new int[M];
        DFS(out, 0);
        System.out.println(sb.toString());
    }

    static void DFS(int[] out, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(out[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = i;
                DFS(out, depth + 1);
                visited[i] = false;
            }
        }
    }
}
