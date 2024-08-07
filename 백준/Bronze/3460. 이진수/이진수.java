import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringBuilder answer = new StringBuilder();
    public static void recursive(int n) {
        if (n == 0) return;
        int mod = n % 2;
        sb.append(mod);
        recursive(n / 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            recursive(n);
            for (int j = 0; j < sb.length(); j++) {
                if(sb.charAt(j) == '1') {
                    answer.append(j).append(" ");
                }
            }
            sb.setLength(0);
            answer.append("\n");
        }
        System.out.println(answer.toString());
    }
}