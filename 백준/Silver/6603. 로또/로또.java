
import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static boolean[] visit;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n == 0) break;

            visit = new boolean[n];
            arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            DFS(0, 0);
            System.out.println();
        }
    }

    static void DFS(int start, int cnt) {
        if(cnt==6) {
            for(int i=0; i<n; i++) {
                if(visit[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        for(int i=start; i<n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                DFS(i+1, cnt+1);
                visit[i] = false;
            }
        }
    }
}
