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

        int[] answer = new int[2];
        int minInterval = Integer.MAX_VALUE;
        Arrays.sort(arr);
        int lt = 0, rt = N-1;

        while(lt < rt) {
            if(arr[lt] + arr[rt] < 0) { // 합이 0보다 작으면 0에 가깝게 하기 위해 lt ++
                if(Math.abs(arr[lt] + arr[rt]) < minInterval) {
                    minInterval = Math.abs(arr[lt] + arr[rt]);
                    answer[0] = arr[lt];
                    answer[1] = arr[rt];
                }
                lt++;
            } else if(arr[lt] + arr[rt] > 0) { // 합이 0보다 크면 0에 가깝게 하기 위해 rt --
                if(Math.abs(arr[lt] + arr[rt]) < minInterval) {
                    minInterval = Math.abs(arr[lt] + arr[rt]);
                    answer[0] = arr[lt];
                    answer[1] = arr[rt];
                }
                rt--;
            } else {
                answer[0] = arr[lt];
                answer[1] = arr[rt];
                break;
            }
        }

        Arrays.sort(answer);
        System.out.println(answer[0] + " " + answer[1]);
    }
}
