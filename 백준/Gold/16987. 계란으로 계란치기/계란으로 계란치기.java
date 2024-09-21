import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N, answer;
    static int[][] arr;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2]; // 각 계란의 내구도, 무게
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int depth, int cnt) {
        if (depth == N) { // 손에 든 계란이 가장 오른쪽일 경우 종료
            answer = Math.max(answer, cnt);
            return;
        }

        if (arr[depth][0] <= 0 || cnt == N-1) { // 손에 든 계란이 이미 깨진경우 + 모든 계란이 이미 깨진 경우
            dfs(depth + 1, cnt);
            return;
        }

        int nCnt = cnt;
        for (int i = 0; i < N; i++) {
            if (depth == i) continue; // 자기 자신인 경우
            if (arr[i][0] <= 0) continue; // 부딪히려는 계란이 이미 깨진 경우

            // 계란 때리기
            arr[depth][0] -= arr[i][1];
            arr[i][0] -= arr[depth][1];

            if (arr[depth][0] <= 0) cnt++;
            if (arr[i][0] <= 0) cnt++;
            dfs(depth+1, cnt);

            // 계란 복구
            arr[depth][0] += arr[i][1];
            arr[i][0] += arr[depth][1];

            // 횟수 복구
            cnt = nCnt;
        }
    }
}