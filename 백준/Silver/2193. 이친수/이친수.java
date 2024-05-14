import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] DP = new long[91];
        DP[1] = 1;
        DP[2] = 1;

        for(int i=3;i<=N;i++) {
            DP[i] = DP[i-1] + // i가 0인경우 i-1이 0 or 1이므로 i-1까지의 경우의 수와 같다.
                    DP[i-2]; // i가 1인경우 i-1은 무조건 0이고 i-2가 0 or 1이므로 i-2까지의 경우의 수와 같다.
        }

        System.out.println(DP[N]);
    }
}
