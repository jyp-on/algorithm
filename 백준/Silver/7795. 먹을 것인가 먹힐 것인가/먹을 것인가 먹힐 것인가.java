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

            Arrays.sort(B);
            int cnt = 0;

            for (int j = 0; j < N; j++) {
                int first = 0;
                int end = M - 1;
                int index = 0;

                while (first <= end) {
                    int mid = (first + end) / 2;
                    if (B[mid] < A[j]) {
                        first = mid + 1;
                        index = mid + 1;
                    }
                    else {
                        end = mid - 1;
                    }
                }
                cnt += index;
            }

            System.out.println(cnt);
        }
    }
}
