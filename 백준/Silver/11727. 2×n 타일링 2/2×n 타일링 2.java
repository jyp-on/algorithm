import java.io.*;
import java.util.*;

public class Main {

    static int[] dp = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;
        System.out.print(DP(sc.nextInt()));
    }

    public static int DP(int x) {
        if(dp[x] != 0) return dp[x];
        return dp[x] = (DP(x-1) + 2*DP(x-2)) % 10007;
    }
}