import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= n/5; i++) { // 5원 동전의 개수
            int remain = n - (i * 5);
            if (remain % 2 == 0) {
                ans = Math.min(ans, i + remain/2);
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}