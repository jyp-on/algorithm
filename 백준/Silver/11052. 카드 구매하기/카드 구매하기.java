import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1]; // k개의 카드를 살때의 최대 값
        // D[1] => P[1] = 1
        // D[2] => (D[0] + P[2], D[1] + P[1]) = 5
        // D[3] => (D[0] + P[3], D[1] + P[2], D[2] + P[1]) = 6

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=i; j++) {
                dp[i] = Math.max(dp[i], dp[i-j] + P[j]);
            }
        }

        System.out.println(dp[N]);
    }
}