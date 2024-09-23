import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] P = new int[N+1];
        int[] dp = new int[K+1]; // 가치의 합이 I일 때 필요한 동전의 최소 개수
        Arrays.fill(dp, K+1); // Integer.MAX_VALUE 로 하면 OverFlow 발생 !
        dp[0] = 0;
        for(int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(br.readLine());
            for(int j = P[i]; j <= K; j++) {
                dp[j] = Math.min(dp[j - P[i]] + 1, dp[j]);
            }
        }

        System.out.println(dp[K] > K ? -1 : dp[K]);
    }
}