class Solution {
    public boolean validPalindrome(String s) {
        int lt = 0, rt = s.length() - 1;
        
        while (lt < rt) {
            if (s.charAt(lt) != s.charAt(rt)) {
                // 한 번의 기회로 왼쪽을 건너뛰거나, 오른쪽을 건너뛰어서 검사
                return isPalindromeRange(s, lt + 1, rt) || isPalindromeRange(s, lt, rt - 1);
            }
            lt++;
            rt--;
        }
        
        return true;
    }
    
    private boolean isPalindromeRange(String s, int lt, int rt) {
        while (lt < rt) {
            if (s.charAt(lt) != s.charAt(rt)) {
                return false;
            }
            lt++;
            rt--;
        }
        return true;
    }
}
