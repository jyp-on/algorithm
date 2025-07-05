import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        while(true) {
            String input = br.readLine();
            if (input.equals("end")) break;

            int c1 = 0; // 모음연속
            int c2 = 0; // 자음연속
            char prev = '\0'; // 초기값을 null 문자로 설정
            boolean case1 = false; // 모음을 하나라도 포함하는지 여부
            boolean case2 = false; // 3개 연속 모음/자음 규칙 위반 여부
            boolean case3 = false; // 같은 글자 연속 규칙 위반 여부

            for(char i : input.toCharArray()) {
                if(i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u') {
                    case1 = true;
                    c1++;
                    c2 = 0;
                } else {
                    c2++;
                    c1 = 0;
                }

                if(c1 >= 3 || c2 >= 3) {
                    case2 = true;
                    break;
                }

                if (prev != '\0' && prev == i) {
                    if (i != 'e' && i != 'o') {
                        case3 = true;
                        break;
                    }
                }
                prev = i;
            }

            if(case1 && !case2 && !case3) {
                ans.append("<").append(input).append("> is acceptable.\n");
            } else {
                ans.append("<").append(input).append("> is not acceptable.\n");
            }
        }

        System.out.print(ans); // println -> print로 변경
    }
}