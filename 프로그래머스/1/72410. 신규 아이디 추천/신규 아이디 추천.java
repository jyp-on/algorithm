import java.util.*;
class Solution {
    public String solution(String new_id) {
        String l1 = "";
        // 1단계
        for(char x : new_id.toCharArray()) {
            if((int)x >= 65 && (int)x <= 90) l1 += (char)((int)x + 32);
            else l1 += x;
        }
        // 2단계
        String l2 = "";
        for(char x : l1.toCharArray()) {
            if(Character.isAlphabetic(x) || Character.isDigit(x) || x == '-' || x == '_' || x == '.') { // 소문자 알파벳
                l2 += x;
            }
        }
        // 3단계
        String l3 = "";
        Stack<Character> stack = new Stack<>();
        stack.add('0');
        for(char x : l2.toCharArray()) {
            if(stack.peek() == '.' && x == '.') continue;
            else {
                stack.add(x);
                l3 += x;
            }
        }
        // 4단계
        if(l3.charAt(0) == '.') l3 = l3.substring(1, l3.length());
        if(l3.length() >= 1 && l3.charAt(l3.length()-1) == '.') l3 = l3.substring(0, l3.length()-1);
        // 5단계
        if(l3.length()==0) l3 = "a";
        // 6단계
        if(l3.length()>=16) l3 = l3.substring(0, 15);
        if(l3.charAt(l3.length()-1)=='.') l3 = l3.substring(0, l3.length()-1);
        // 7단계
        if(l3.length()<=2) {
            char last = l3.charAt(l3.length()-1);
            while(l3.length() <= 2) {
                l3 += last;
            }
        }
        return l3;
    }
}