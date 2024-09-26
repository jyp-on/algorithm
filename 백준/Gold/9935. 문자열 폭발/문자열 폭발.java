import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        String str = br.readLine();
        String bomb = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            boolean isMatch = true;
            if (sb.length() >= bomb.length()) {
                for (int j = 0; j < bomb.length(); j++) {
                    if (sb.charAt(sb.length() - bomb.length() + j) != bomb.charAt(j)) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    sb.setLength(sb.length() - bomb.length());
                }
            }
        }

        System.out.println(sb.length() > 0 ? sb : "FRULA");
    }
}