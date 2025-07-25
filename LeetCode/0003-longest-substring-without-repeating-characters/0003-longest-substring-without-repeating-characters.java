class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>(); // 문자, 위치
        int left = 0, maxLen = 0;

        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if(map.containsKey(c) && map.get(c) >= left) { // 겹치는 문자가 윈도우 안에 있는지
                left = map.get(c) + 1;
            }

            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}