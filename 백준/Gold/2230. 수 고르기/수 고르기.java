import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int lt = 0;
        int rt = 1;
        int ans = Integer.MAX_VALUE;
        while (rt < N) {
            while (lt < rt) {
                int diff = arr[rt] - arr[lt];
                if(diff >= M) {
                    ans = Math.min(ans, diff);
                    lt++;
                } else break;
            }

            rt++;
        }
        System.out.println(ans);
    }
}