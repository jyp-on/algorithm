import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] res = new int[2];
        int minInterval = Integer.MAX_VALUE;
        Arrays.sort(arr);
        int lt = 0, rt = N-1;

        while(lt < rt) {
            int sum = arr[lt] + arr[rt];

            if(Math.abs(sum) < minInterval) {
                minInterval = Math.abs(sum);
                res[0] = arr[lt];
                res[1] = arr[rt];
                if(sum == 0) break;
            }

            if(sum < 0) lt++;
            else rt--;
        }

        System.out.println(res[0] + " " + res[1]);
    }
}
