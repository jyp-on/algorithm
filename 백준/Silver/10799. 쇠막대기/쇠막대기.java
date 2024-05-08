import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i)=='(') {
                stack.push('(');
                continue;
            }
            if(str.charAt(i)==')') {
                stack.pop();

                if(str.charAt(i-1)=='(') {
                    answer += stack.size();
                } else {
                    answer += 1;
                }
            }




        }
        System.out.println(answer);

    }
}