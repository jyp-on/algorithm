class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(char x : s.toCharArray()) {
            if(x == ' ') answer += ' ';
            else {
                if((int)x >= 65 && (int)x <= 90) answer += (char) ((x - 'A' + n) % 26 + 65);
                else answer += (char) ((x - 'a' + n) % 26 + 97);
            }
        }
        return answer;
    }
}