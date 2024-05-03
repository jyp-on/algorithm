import java.util.*;
import java.io.*;

public class Main {
    static int N, S;
    static int[] arr;
    static boolean[] visit;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visit = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        DFS(0, 0, 0);
        System.out.println(answer);
    }

    static void DFS(int start, int cnt, int sum) {
        if(cnt==N) {
            if(sum==S) {
                answer++;
            }
            return;
        }
        if(sum==S && cnt!=0) {
     /*       for(int i=0; i<N; i++) {
                System.out.print(visit[i] + " ");
            }
            System.out.println();*/
            answer++;
        }

        for(int i=start; i<N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                DFS(i+1, cnt+1, sum+arr[i]);
                visit[i] = false;
            }
        }
    }

}