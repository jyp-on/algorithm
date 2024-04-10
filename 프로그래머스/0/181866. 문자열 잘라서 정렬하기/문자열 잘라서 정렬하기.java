import java.util.*;
class Solution {
    public String[] solution(String myString) {
        ArrayList<String> arr = new ArrayList<>();
        for(String x : myString.split("x")) {
            if(!x.equals("")) arr.add(x);
        }
        Collections.sort(arr);
        return arr.toArray(String[]::new);
    }
}