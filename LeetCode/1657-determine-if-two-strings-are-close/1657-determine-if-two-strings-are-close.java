import java.util.*;
class Solution {
    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
        for(char c : word1.toCharArray()) {
            m1.put(c, m1.getOrDefault(c, 0) + 1);
        }
        for(char c : word2.toCharArray()) {
            m2.put(c, m2.getOrDefault(c, 0) + 1);
        }

        for(char k1 : m1.keySet()) {
            if(!m2.containsKey(k1)) return false;
        }

        List<Integer> v1 = new ArrayList<>(m1.values().stream().toList());
        List<Integer> v2 = new ArrayList<>(m2.values().stream().toList());

        if(v1.size() != v2.size()) return false;

        Collections.sort(v1);
        Collections.sort(v2);

        for(int i = 0; i < v1.size(); i++) {
            if(!v1.get(i).equals(v2.get(i))) {
                return false;
            }
        }

        return true;
    }
}