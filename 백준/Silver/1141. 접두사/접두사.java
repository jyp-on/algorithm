import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr);
        
        int cnt = 0;
        for(int i = 0; i < n-1; i++) {
            if(!isPrefix(arr[i], arr[i+1])) {
                cnt++;
            }
        }

        System.out.println(cnt+1);
    }

    static boolean isPrefix(String prefix, String s) {
        for(int i = 0; i < prefix.length(); i++) {
            if(prefix.charAt(i) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
