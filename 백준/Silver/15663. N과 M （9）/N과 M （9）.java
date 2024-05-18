import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] arr, ans;
    static StringBuilder sb = new StringBuilder();
    static Set<String> set = new HashSet<>();
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        ans = new int[m];
        visit = new boolean[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        select(0, sb);
    }

    static void select(int depth, StringBuilder sb) {
        if(depth==m) {
            if(!set.contains(sb.toString())) {
                set.add(sb.toString());
                System.out.println(sb.toString());
            }
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                sb.append(arr[i]).append(" ");
                select(depth+1, sb);
                sb.delete(sb.length()-String.valueOf(arr[i]).length()-1, sb.length());
                visit[i] = false;
            }
        }
    }
}