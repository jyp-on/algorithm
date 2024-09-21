import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int start = 0;
        int end = 0;
        int[] cnt = new int[100001]; // 1 ~ 100000
        while (end < N) {
            while (end < N && cnt[arr[end]] < K) {
                cnt[arr[end]]++;
                end++;
            }
            ans = Math.max(ans, end - start);
            cnt[arr[start]]--;
            start++;
        }

        System.out.println(ans);
    }
}