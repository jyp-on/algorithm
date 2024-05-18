import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        visit = new boolean[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        select(0, "");
    }

    static void select(int L, String str) {
        if(L==m) {
            str = str.replaceFirst(" ", "");
            System.out.println(str);
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                select(L+1, str + " " + arr[i]);
                visit[i] = false;
            }
        }
    }
}