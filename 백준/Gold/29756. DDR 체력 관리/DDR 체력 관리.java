import java.util.Scanner;

public class Main {
    static final int MAX_N = 1001;
    static final int MAX_H = 101;
    static int N, K;
    static int[] S = new int[MAX_N];
    static int[] H = new int[MAX_N];
    static int[][] DP = new int[MAX_N][MAX_H];
    static int Answer;

    public static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            S[i] = sc.nextInt();
        }
        for (int i = 1; i <= N; i++) {
            H[i] = sc.nextInt();
        }
    }

    public static int topDown(int Depth, int Health) {
        if (Depth == 0) {
            return 0;
        }

        int NextHealth = Math.min(Health + K, 100);
        if (DP[Depth][NextHealth] != 0) {
            return DP[Depth][NextHealth];
        }

        int Result = topDown(Depth - 1, NextHealth);
        if (NextHealth - H[Depth] >= 0) {
            Result = Math.max(Result, topDown(Depth - 1, NextHealth - H[Depth]) + S[Depth]);
        }

        return DP[Depth][NextHealth] = Result;
    }

    public static void settings() {
        Answer = topDown(N, 100);
    }

    public static void findAnswer() {
        System.out.println(Answer);
    }

    public static void main(String[] args) {
        input();
        settings();
        findAnswer();
    }
}
