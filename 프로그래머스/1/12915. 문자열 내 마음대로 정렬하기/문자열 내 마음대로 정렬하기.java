import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int res = a.charAt(n) - b.charAt(n);
                if(res == 0) { // n번째 index의 char가 같으면
                    return a.compareTo(b);
                }
                return res;
            }
        });
        
        return strings;
    }
}