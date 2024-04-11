import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        ArrayList<Character> arr = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : X.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        boolean flag = true; // 0만 있는지
        for(char y : Y.toCharArray()) {
            if(map.containsKey(y)) {
                map.put(y, map.get(y)-1);
                if(map.get(y) == 0) map.remove(y);
                arr.add(y);
                if(y != '0') flag = false;
            }
        }
        if(arr.size() == 0) return "-1";
        if(flag) return "0";
        Collections.sort(arr, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(char x : arr) sb.append(x);
        
        return sb.toString();
    }
}