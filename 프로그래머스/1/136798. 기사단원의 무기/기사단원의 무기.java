class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1; i<=number; i++) {
            answer += getCnt(i, limit, power);
        }
        return answer;
    }
    private int getCnt(int n, int limit, int power) {
        int cnt = 0;
        for(int i = 1; i <= Math.sqrt(n); i++) {
            if(i==Math.sqrt(n) && n%i==0) cnt+=1;
            else if(n%i==0) cnt+=2;
            
            if(cnt>limit) return power;
        }
        
        return cnt;
    }
}