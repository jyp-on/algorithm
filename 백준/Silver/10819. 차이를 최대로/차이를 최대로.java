import java.io.*;
import java.util.*;

public class Main {

    static int n, answer;
    static int[] arr, target;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        answer = -1;
        arr = new int[n];
        target = new int[n];
        visit = new boolean[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        select(0);
        System.out.println(answer);
    }

    static void select(int depth) {
        if(depth == n) {
            int sum = 0;
            for(int i=0; i<n-1; i++) {
//                System.out.print(target[i] + " " + target[i+1] + " ");
                sum += Math.abs(target[i] - target[i+1]);
            }
//            System.out.print(" -> " + sum + "\n");
            answer = Math.max(answer, sum);
            return;
        }

        for(int i=0; i<n; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            target[depth] = arr[i];
            select(depth+1);
            visit[i] = false;
        }
    }
}