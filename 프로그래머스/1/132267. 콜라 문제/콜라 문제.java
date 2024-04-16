class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a) {
            int q = n / a; 
            n = n - (a * q) + (q * b);
            answer += (q * b);
        }
        return answer;
    }
}