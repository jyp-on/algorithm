import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> map = new HashMap<>(); // 각 문자당 가장 먼저 나온 index 저장
        for(String km : keymap) {
            for(int i = 0; i < km.length(); i++) {
                if(map.getOrDefault(km.charAt(i), 102) > i+1) {
                    map.put(km.charAt(i), i+1);
                }
            }
        }
        // System.out.println(map);
        int ans_idx = 0;
        for(String target : targets) {
            int sum = 0;
            boolean flag = true;
            for(char t : target.toCharArray()) {
                if(!map.containsKey(t)) {
                    answer[ans_idx++] = -1;
                    flag = false;
                    break;
                } 
                sum += map.get(t);
            }
            if(flag) answer[ans_idx++] = sum;
        }
        return answer;
    }
}