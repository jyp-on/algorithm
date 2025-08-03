class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

        List<String> ans = new ArrayList<>();
        if(digits.length()==0) return ans;

        backTracking(digits, 0, new StringBuilder(), map, ans);

        return ans;
    }   

    void backTracking(String digits, int idx, StringBuilder path, Map<Character, String> map, List<String> ans) {
        if(idx == digits.length()) {
            ans.add(path.toString());
            return;
        }

        char digit = digits.charAt(idx);
        String letters = map.get(digit);

        for(char letter : letters.toCharArray()) {
            path.append(letter);
            backTracking(digits, idx+1, path, map, ans);
            path.deleteCharAt(path.length()-1);
        }
    }
}