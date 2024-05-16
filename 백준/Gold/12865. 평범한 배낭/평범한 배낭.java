import java.io.*;
import java.util.*;

public class Main {

    static int[][] dp;
    static int[] W; // weight
    static int[] V; // value

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        W = new int[N];
        V = new int[N];

        dp = new int[N][K + 1]; // 현재 몇번째 물건까지 탐색했는지, 현재 용량

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(knapsack(N - 1, K));

    }

    // i는 현재 물건의 idx, k는 배낭에 남은 무게
    static int knapsack(int idx, int k) {
        if(idx<0)
            return 0;

        if(dp[idx][k] == 0) { // 탐색하지 않은 경우
            if(W[idx] <= k) { // idx에 해당하는 물건을 가방에 담을 수 있다면
                // 현재 물건을 고르지 않은경우와 고른경우 중 MAX값 선택
                dp[idx][k] = Math.max(knapsack(idx - 1, k), knapsack(idx - 1, k - W[idx]) + V[idx]);
            } else {
                dp[idx][k] = knapsack(idx - 1, k);
            }
        }

        return dp[idx][k];
    }
}