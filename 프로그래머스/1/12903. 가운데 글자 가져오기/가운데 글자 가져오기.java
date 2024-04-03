class Solution {
    public String solution(String s) {
        int n = s.length();
        if(n % 2 == 0) return s.charAt(n/2-1) + "" + s.charAt(n/2);
        else return String.valueOf(s.charAt(n/2));
    }
}