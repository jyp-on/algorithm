import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long ans = 0;
        Stack<Integer> stack = new Stack<>(); // stack의 size는 볼 수 있는것들의 개수

        for(int i=0; i<n; i++) {
            int height = sc.nextInt();
            while(!stack.isEmpty()) {

                if(stack.peek() <= height) {
                    // i번째 빌딩보다 낮거나 같은 애들은 빼버린다.
                    stack.pop();
                }
                else break;
            }
//            System.out.println(stack.size());
            ans += stack.size(); //스택 사이즈를 더함으로써, 벤치마킹 가능한 개수를 더해준다.
            stack.push(height); //i번째 빌딩의 높이를 넣어준다.

        }

        System.out.println(ans);
    }
}