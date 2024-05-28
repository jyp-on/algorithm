class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int len = sticker.length;

        if (len == 1) return sticker[0];

        int [] dp = new int[len];

        // 첫 번째 스티커를 뗐을때 (마지막 스티커는 뗄 수 없음)
        dp[0] = sticker[0];
        dp[1] = dp[0];
        for(int i=2; i<len-1; i++) {
            dp[i] = Math.max(dp[i-2] + sticker[i], dp[i-1]);
        }

        answer = dp[len-2];
        
        // 첫 번째 스티커를 안뗏을 때 (마지막 스티커 뗄 수 있음)
        dp[0] = 0;
        dp[1] = sticker[1];
        for(int i=2; i<len; i++) {
            dp[i] = Math.max(dp[i-2] + sticker[i], dp[i-1]);
        }
        
        answer = Math.max(answer, dp[len-1]);
        
        return answer;
    }
}