import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        combination(arr, new int[M], 0, 0, M);

    }

    public static void combination(int[] arr, int[] out, int start, int depth, int r) {
        if (depth == r) {
            StringBuilder sb = new StringBuilder();
            for (int a : out) {
                sb.append(a).append(" ");
            }
            System.out.println(sb);
            return;
        }
        for (int i = start; i < arr.length; i++) {
            out[depth] = arr[i];
            combination(arr, out, i + 1, depth + 1, r);

        }
    }
}