import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String input = br.readLine();

        char[] arr = input.toCharArray();
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            // 데크의 맨 뒤의 값이 arr[i]보다 작으면 삭제한다.
            // 아래 조건을 만족할 때까지 반복.
            while (K > 0 && !dq.isEmpty() && dq.getLast() < arr[i]) {
                dq.removeLast();
                K--;
            }
            dq.addLast(arr[i]);
        }

        StringBuilder ans = new StringBuilder();
        // 위 for문에서 K가 0이 되기 전에 끝난 경우를 대비하여
        // dq.size() - K만큼만 출력한다.
        while (dq.size() > K) {
            ans.append(dq.removeFirst());
        }
        System.out.println(ans);
    }
}