import java.io.*;
import java.util.*;

public class Main {
    final static long mod = 1000000000;
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][] DP = new long[N+1][10]; // [자리 수][앞에오는 숫자] = 경우의 수
        for(int i=1;i<10;i++) {
            DP[1][i] = 1;
        }

        for(int i=2;i<N+1;i++) {
            for(int j=0;j<10;j++) {
                if(j==0)
                    DP[i][j] = DP[i-1][1] % mod;
                else if(j==9)
                    DP[i][j] = DP[i-1][8] % mod;
                else
                    DP[i][j] = (DP[i-1][j-1] + DP[i-1][j+1]) % mod;
            }
        }

        long res = 0;
        for(int i=0; i<10; i++) {
            res += DP[N][i];
        }
        System.out.println(res % mod);
    }
}
