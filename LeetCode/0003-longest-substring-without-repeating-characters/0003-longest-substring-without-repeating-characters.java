class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        
        char[] arr = s.toCharArray();
        int answer = 0;
        
        for(int i = 0; i < arr.length; i++) {
            Set<Character> set = new HashSet<>();
            int j;
            for(j = i; j < arr.length; j++) {
                if(set.contains(arr[j])) {
                    break;
                }
                set.add(arr[j]); // 모든 문자 추가 (공백 포함)
            }
            answer = Math.max(answer, j - i); // break든 끝까지든 여기서 계산
        }
        
        return answer;
    }
}