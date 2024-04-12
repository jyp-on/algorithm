class Solution {
    static boolean[] ch = new boolean[1000001]; // 소수면 false
    public int solution(int n) {
        
        for(int i = 2; i <= n; i++) {
            for(int j = 2*i; j <= n; j+=i) {
                ch[j] = true; // 배수들은 소수가 아님
            }
        }
        
        int answer = 0;
        for(int i = 2; i <= n; i++) {
            if(!ch[i]) answer++;
        }
        
        return answer;
    }
}