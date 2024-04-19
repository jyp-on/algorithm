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
        for(int i = 1; i <= Math.sqrt(n); i++) { // 제곱근 까지만 확인
            if(i==Math.sqrt(n) && n%i==0) cnt+=1; // i*i==n 에서 i가 제곱근이라면 약수는 하나증가
            else if(n%i==0) cnt+=2; // 그 외에는 약수가 대칭 되어있으므로 2개씩 증가
            
            if(cnt>limit) return power;
        }
        
        return cnt;
    }
}