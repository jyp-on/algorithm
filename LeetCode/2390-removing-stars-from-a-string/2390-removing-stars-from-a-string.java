import java.util.*;
class Solution {
    public String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()) {
            if(c == '*') stack.removeFirst();
            else {
                stack.addFirst(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : stack) {
            sb.append(c);
        }

        return sb.reverse().toString();
    }
}