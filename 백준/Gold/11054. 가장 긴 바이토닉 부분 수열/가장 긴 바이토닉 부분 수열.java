import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n + 1];
        int[] dp_r = new int[n + 1];
        int[] dp_l = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp_r, 1); // 기본 길이는 모두 1이다
        Arrays.fill(dp_l, 1); // 기본 길이는 모두 1이다

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j] && dp_r[i] < dp_r[j] + 1) {
                    dp_r[i] = dp_r[j] + 1;
                }
            }
        }

        for (int i = n; i >= 1; i--) {
            for (int j = i+1; j <= n; j++) {
                if (arr[i] > arr[j] && dp_l[i] < dp_l[j] + 1) {
                    dp_l[i] = dp_l[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp_r[i] + dp_l[i] - 1);
        }
        System.out.println(max);
    }
}