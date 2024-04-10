import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(char x : my_string.toCharArray()) {
            if(Character.isDigit(x)) {
                arr.add(x - '0');
            }
        }
        Collections.sort(arr);
        return arr.stream().mapToInt(i->i).toArray();
    }
}