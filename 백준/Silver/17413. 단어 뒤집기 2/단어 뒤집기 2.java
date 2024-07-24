import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int p = 0;
        while (p < arr.length) {
            if (arr[p] == '<') {
                // 1. 스택 비우기 (현재까지의 단어 뒤집기)
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }

                // 2. '<'로 시작하는 부분은 그대로 저장
                while (arr[p] != '>') {
                    sb.append(arr[p++]);
                }
                sb.append(arr[p++]);  // '>'도 추가

            } else if (arr[p] == ' ') {
                // 3. 공백 처리 (스택 비우기)
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(arr[p++]); // 공백도 넣기
            } else {
                // 4. 단어 처리 (스택에 문자 넣기)
                stack.push(arr[p++]);
            }
        }

        // 5. 마지막에 남은 스택 비우기
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }
}
