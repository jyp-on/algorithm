import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder(); // 결과를 효율적으로 저장하기 위한 StringBuilder

        while(true) {
            String input = br.readLine();
            if (input.equals("end")) { // "end" 입력 시 종료
                break;
            }

            int consecutiveVowels = 0;    // 연속되는 모음의 개수
            int consecutiveConsonants = 0; // 연속되는 자음의 개수
            char prevChar = ' ';          // 이전 문자를 저장. 초기값은 실제 단어에 나올 수 없는 공백으로 설정
                                          // (또는 null 문자인 '\0' 등 다른 특수 문자를 사용해도 무방)

            boolean hasVowel = false;     // 모음을 하나라도 포함하는지 여부 (규칙 1)
            boolean violatesConsecutiveRule = false; // 3개 연속 모음/자음 규칙 위반 여부 (규칙 2)
            boolean violatesSameCharRule = false;    // 같은 글자 연속 규칙 위반 여부 (규칙 3)

            for (char currentChar : input.toCharArray()) { // 입력 문자열의 각 문자를 순회
                // 1. 모음 포함 여부 확인
                if (isVowel(currentChar)) {
                    hasVowel = true; // 모음을 찾았으니 true로 설정
                    consecutiveVowels++;
                    consecutiveConsonants = 0; // 자음 연속 카운트 리셋
                } else {
                    consecutiveConsonants++;
                    consecutiveVowels = 0; // 모음 연속 카운트 리셋
                }

                // 2. 3개 연속 모음/자음 규칙 위반 확인
                if (consecutiveVowels >= 3 || consecutiveConsonants >= 3) {
                    violatesConsecutiveRule = true;
                    break; // 규칙 위반 시 더 이상 검사할 필요 없으므로 반복 중단
                }

                // 3. 같은 글자 연속 규칙 위반 확인 (단, 'ee'와 'oo'는 예외)
                // prevChar가 초기값이 아니고, 이전 문자와 현재 문자가 같으며,
                // 현재 문자가 'e'나 'o'가 아닐 경우에만 위반으로 간주
                if (prevChar != ' ' && prevChar == currentChar) {
                    if (currentChar != 'e' && currentChar != 'o') {
                        violatesSameCharRule = true;
                        break; // 규칙 위반 시 반복 중단
                    }
                }
                
                prevChar = currentChar; // 현재 문자를 다음 반복을 위한 '이전 문자'로 저장
            }

            // 모든 규칙을 종합하여 결과 출력
            // 'acceptable'은 모든 규칙을 만족할 때만 해당
            // 즉, 모음을 포함하고 (hasVowel == true)
            // 3개 연속 규칙을 위반하지 않고 (violatesConsecutiveRule == false)
            // 같은 글자 연속 규칙을 위반하지 않을 때 (violatesSameCharRule == false)
            if (hasVowel && !violatesConsecutiveRule && !violatesSameCharRule) {
                ans.append("<").append(input).append("> is acceptable.\n");
            } else {
                ans.append("<").append(input).append("> is not acceptable.\n");
            }
        }

        System.out.print(ans); // 최종 결과 출력
        br.close(); // BufferedReader 닫기
    }

    // 모음인지 판별하는 헬퍼 메서드
    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}