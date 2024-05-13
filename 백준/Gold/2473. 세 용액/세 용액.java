import java.io.*;
import java.util.*;

public class Main {
    // input 값이 들어오는 배열 선언
    static long[] arr;
    // 선택하는 3개의 인덱스 값을 넣을 배열 선언
    static int best[] = new int[3];
    // 세 포인터
    static int start, mid, end;
    static long min = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new long[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N - 2; i++) {
            start = i;
            mid = i + 1;
            end = N - 1;
            while (mid < end) {
                long sum = arr[start] + arr[mid] + arr[end];
                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    best[0] = start;
                    best[1] = mid;
                    best[2] = end;
                }
                if (sum == 0) {
                    break;
                } else if (sum > 0) {
                    end--;
                } else {
                    mid++;
                }
            }
        }
        System.out.println(arr[best[0]] + " " + arr[best[1]] + " " + arr[best[2]]);
    }
}
