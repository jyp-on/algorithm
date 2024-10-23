import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder front = new StringBuilder();
        StringBuilder back = new StringBuilder();
        boolean check = true;

        int[] count = new int[26];
        for(char x : S.toCharArray()) {
            count[x - 'A']++;
        }

        int oddCnt = 0;
        char mid = '0';
        for(int i = 0; i < 26; i++) {
            if(count[i] != 0 && count[i] % 2 == 1) { // 홀수개인 경우
                if(oddCnt == 0) {
                    oddCnt++;
                    mid = (char) (i + 'A');
                } else { // 홀수가 2개 이상일 경우
                    System.out.println("I'm Sorry Hansoo");
                    check = false;
                    break;
                }
            }

            for(int j = 0; j < count[i] / 2; j++) {
                front.append((char) (i + 'A'));
                back.append((char) (i + 'A'));
            }
        }

        if(check) {
            if(mid == '0') System.out.println(front.toString() + back.reverse().toString());
            else System.out.println(front.toString() + mid + back.reverse().toString());
        }
    }
}