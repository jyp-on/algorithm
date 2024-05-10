import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int s = 0, e = k, sum = 0 , ans = 0;
        for(int i=0; i<e; i++) {
            sum += arr[i];
        }
        ans = sum;
        while(e<n) {
            sum -= arr[s++];
            sum += arr[e++];
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }
}
