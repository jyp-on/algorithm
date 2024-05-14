import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[10010];
        int[] DP = new int[10010];
        for(int i=1; i<=N; i++) {
            arr[i] = sc.nextInt();
        }

        DP[1] = arr[1];
        DP[2] = DP[1] + arr[2];

        for(int i=3; i<=N; i++) {
            DP[i] = Math.max(Math.max(DP[i-2] + arr[i], DP[i-3] + arr[i-1] + arr[i]), DP[i-1]);
        }

        System.out.println(DP[N]);
    }
}
