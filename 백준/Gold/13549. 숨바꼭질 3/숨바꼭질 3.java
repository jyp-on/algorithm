import java.util.*;
import java.io.*;

public class Main {
//    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    private static StringTokenizer st;
    static final int MAX = 100001;
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String args[]) throws IOException {
        int N = sc.nextInt();
        int K = sc.nextInt();
        System.out.println(bfs(N, K));
    }

    private static int bfs(int N, int K) {
        int[] dist = new int[MAX];
        Arrays.fill(dist, -1);
        Deque<Integer> q = new LinkedList<>();
        q.add(N);
        dist[N] = 0;
        while (!q.isEmpty()) {
            int x = q.poll();
            if (x == K) {
                return dist[K];
            }

            // 순간이동은 먼저 검사하기 위해 앞쪽에 추가
            if (x*2 < MAX && dist[x*2] == -1) {
                dist[x*2] = dist[x];
                q.addFirst(x*2);
            }

            for (int nx : new int[]{x - 1, x + 1}) {
                if (nx >= 0 && nx < MAX && dist[nx] == -1) {
                    dist[nx] = dist[x] + 1;
                    q.addLast(nx);  // 걷기는 덱의 뒤쪽에 추가
                }
            }


        }

        return 0;
    }
}