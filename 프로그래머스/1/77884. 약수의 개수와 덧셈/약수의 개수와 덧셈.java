class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++) {
            if(isEven(i)) answer += i;
            else answer -= i;
        }
        return answer;
    }
    
    // 약수의 개수가 짝수개면 true
    public static boolean isEven(int x) {
        int cnt = 0;
        for(int i = 1; i <= x; i++) {
            if(x % i == 0) cnt++;
        }
        return cnt % 2 == 0;
    }
}