import java.util.*;

public class Solution {
    public Stack<Integer> solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for(int i=1; i<arr.length; i++) if(arr[i] != stack.peek()) stack.push(arr[i]);
        return stack;
    }
}