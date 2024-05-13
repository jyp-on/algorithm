import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int lt=0, rt = n-1, cnt=0;
        while(lt<rt) {
            int sum = arr[lt] + arr[rt];
            if(sum == x) cnt++;

            if(sum > x) rt--;
            else lt++;
        }

        System.out.println(cnt);
    }
}
