import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n+1];
            int[][] DP = new int[2][n+1];
            for(int j=0; j<2; j++){
                String[] inputs = br.readLine().split(" ");
                for (int k = 1; k <= n; k++) {
                    arr[j][k] = Integer.parseInt(inputs[k-1]);
                }
            }

            // 첫번째 column은 자기 자신이 최대이므로 자기 자신으로 초기화
            DP[0][1] = arr[0][1];
            DP[1][1] = arr[1][1];

            for (int j = 2; j <= n; j++) {
                DP[0][j] = Math.max(DP[1][j - 1], DP[1][j - 2]) + arr[0][j];
                DP[1][j] = Math.max(DP[0][j - 1], DP[0][j - 2]) + arr[1][j];
            }

            System.out.println(Math.max(DP[0][n], DP[1][n]));


        }
    }
}
