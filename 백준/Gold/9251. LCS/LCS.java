import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();
        int length_A = A.length;
        int length_B = B.length;
        int[][] dp = new int[length_A+1][length_B+1];

        for (int i = 1; i <= length_A; i++) {
            for (int j = 1; j <= length_B; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[length_A][length_B]);
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(dp[j][i]);
//            }
//            System.out.println();
//        }
    }
}