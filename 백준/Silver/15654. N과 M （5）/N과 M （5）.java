import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] arr, ans;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        ans = new int[n];
        visit = new boolean[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        select(0);
        System.out.println(sb);
    }

    static void select(int L) {
        if(L==m) {
            for(int i=0; i<m; i++) {
                sb.append(ans[i]+ " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                ans[L] = arr[i];
                select(L+1);
                visit[i] = false;
            }
        }
    }
}