class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, min_v = prices[0];
        for(int i=1; i<prices.length; i++) {
            if(prices[i]<min_v) {
                min_v = prices[i];
            } else {
                max = Math.max(max, prices[i]-min_v);
            }
        }

        return max;
    }
}