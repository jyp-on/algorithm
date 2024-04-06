import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < topping.length; i++) {
            setA.add(topping[i]);
            map.put(topping[i], map.getOrDefault(topping[i], 0)+1);
        }
        System.out.println(setA + "\n" + map);
        for(int i = 0; i < topping.length; i++) {
            map.put(topping[i], map.get(topping[i])-1);
            setB.add(topping[i]);
            if(map.get(topping[i]) == 0) setA.remove(topping[i]);
            if(setA.size() == setB.size()) answer++;
        }
        return answer;
    }
}