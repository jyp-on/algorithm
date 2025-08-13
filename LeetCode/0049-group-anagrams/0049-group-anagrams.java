class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for(String str : strs) {
            Map<Character, Integer> temp = new HashMap<>();
            for(char c : str.toCharArray()) {
                temp.put(c, temp.getOrDefault(c, 0)+1);
            }
            map.putIfAbsent(temp, new ArrayList<>());
            map.get(temp).add(str);
        }

        for(Map.Entry<Map<Character, Integer>, List<String>> m : map.entrySet()) {
            answer.add(m.getValue());
            // System.out.println(m.getKey().toString());
            // System.out.println(m.getValue().toString());
            // System.out.println("======================");
        }

        return answer;
    }
}