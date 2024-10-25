import java.util.*;
class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int sum = 0;
        boolean hasOdd = false; // 홀수 개수의 문자가 있는지 확인하는 플래그
        for (var entry : map.entrySet()) {
            int count = entry.getValue();
            if (count % 2 == 0) {
                sum += count; // 짝수인 경우 그대로 추가
            } else {
                sum += count - 1; // 홀수인 경우 하나를 빼고 추가
                hasOdd = true;    // 홀수 개수의 문자가 존재함을 표시
            }
        }
        
        // 홀수가 있는 경우 하나의 홀수만 가운데에 위치할 수 있도록 +1
        return hasOdd ? sum + 1 : sum;
    }
}
