import java.util.*;
import java.io.*;

public class Main {
    static final int MAX = 100001;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] result = bfs(N, K);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    private static int[] bfs(int N, int K) {
        int[] time = new int[MAX];
        int[] count = new int[MAX];
        Arrays.fill(time, -1);

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        time[N] = 0;
        count[N] = 1;

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int nx : new int[]{x * 2, x + 1, x - 1}) {
                if (nx >= 0 && nx < MAX) {
                    if (time[nx] == -1) {
                        time[nx] = time[x] + 1;
                        count[nx] = count[x];
                        q.offer(nx);
                    } else if (time[nx] == time[x] + 1) {
                        count[nx] += count[x];
                    }
                }
            }
        }

        return new int[]{time[K], count[K]};
    }
}