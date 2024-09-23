import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] P = new int[N+1];
        for (int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[K+1]; // 가치의 합이 I 원인 경우의 수
        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = P[i]; j <= K; j++) {
                dp[j] += dp[j - P[i]];
            }
        }

        System.out.println(dp[K]);
    }
}