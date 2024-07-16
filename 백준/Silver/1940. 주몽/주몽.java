import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int lt = 0, rt = N - 1, cnt = 0;
        while(lt < rt) {
            if(arr[lt] + arr[rt] < M) {
                lt++;
            } else if(arr[rt] + arr[lt] > M) {
                rt--;
            } else {
                cnt++;
                lt++;
            }
        }

        System.out.println(cnt);
    }
}
