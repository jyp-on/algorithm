import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o2[1] - o1[1];
            }
            if (o1[2] != o2[2]) {
                return o2[2] - o1[2];
            }
            if (o1[3] != o2[3]) {
                return o2[3] - o1[3];
            }
            return 0;
        });

        int cnt = 1;
        int a=-1, b=-1, c=-1;
        for (int i = 0; i < n; i++) {
            if(arr[i][0]==k) {
                if(a==arr[i][1] && b==arr[i][2] && c==arr[i][3]) {
                    System.out.println(cnt-1);
                } else {
                    System.out.println(cnt);
                }
                break;
            }
//            System.out.printf("%d %d %d %d, cnt : %d\n", arr[i][0], arr[i][1], arr[i][2], arr[i][3], cnt);
            if(a==arr[i][1] && b==arr[i][2] && c==arr[i][3]) continue;
            a = arr[i][1];
            b = arr[i][2];
            c = arr[i][3];
            cnt++;
        }
    }
}