import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] A = new int[N];
            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                A[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                B[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A);
            Arrays.sort(B);

            int cnt = 0;
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(A[j]>B[k]) cnt++;
                    else break;
                }
            }

            System.out.println(cnt);
        }
    }
}
