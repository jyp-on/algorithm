

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] out = new int[M];
        combination(out, 1, 0);
        System.out.println(sb.toString());
    }

    public static void combination(int[] out, int start, int depth) {
        if (depth == M) {
            for (int a : out) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= N; i++) {
            out[depth] = i;
            combination(out, i + 1, depth + 1);
        }
    }
}