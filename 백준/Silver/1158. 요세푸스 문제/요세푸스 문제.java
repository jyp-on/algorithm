import java.io.*;
import java.util.*;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        int[] answer = new int[N];
        for(int i=0; i<N; i++) {
            q.add(i+1);
        }

        int idx = 0;
        int cnt = 0;
        while(!q.isEmpty()) {
            cnt++;
            int x = q.poll();
            if(cnt==K) {
                answer[idx++] = x;
                cnt = 0;
            } else {
                q.add(x);
            }
        }


        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i=0; i<N; i++) {
            sb.append(answer[i] + ", ");
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append(">");
        System.out.println(sb.toString());
    }
}