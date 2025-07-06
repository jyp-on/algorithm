import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][3];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dp = new int[m+1];

        for(int i = 0;i<=m;i++){
            dp[i] = i;
        }

        for(int i=1; i<=m; i++) {
            // 지름길을 타지 않는 경우가 더 빠를 수 있으니 직전 + 1 로 항상 업데이트
            dp[i] = Math.min(dp[i], dp[i-1]+1);
            for(int j=0; j<n; j++) { // 지름길 조회
                if(arr[j][1]==i) { // 도착지가 i인 경우
                    // Math.min(현재까지의 최단거리, 지름길 시작점 까지의 최단거리 + 해당 지름길을 탔을 경우 소모되는 거리) 중 더 적은 경우 선택
                    dp[i] = Math.min(dp[i], dp[arr[j][0]] + arr[j][2]);
                }
            }
        }

//        for(int i=0; i<=m; i++){
//            System.out.printf("%d ", dp[i]);
//        }

        System.out.println(dp[m]);
    }
}