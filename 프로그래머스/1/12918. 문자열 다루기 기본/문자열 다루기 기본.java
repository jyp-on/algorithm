class Solution {
    public boolean solution(String s) {
        int len = s.length();
        if(len != 4 && len != 6) return false;
        for(char x : s.toCharArray()) {
            if(!Character.isDigit(x)) return false;
        }
        return true;
    }
}