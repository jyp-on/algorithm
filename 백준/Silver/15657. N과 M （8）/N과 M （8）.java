import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] arr, ans;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        ans = new int[m];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        select(0, 0);
        System.out.println(sb);
    }

    static void select(int depth, int start) {
        if(depth==m) {
            for(int i=0; i<m; i++) {
                sb.append(ans[i]+ " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<n; i++) {
            ans[depth] = arr[i];
            select(depth+1, i);
        }
    }
}