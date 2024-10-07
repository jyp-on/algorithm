class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        switch (n) {
            case 1:
                return nums[0];
            case 2:
                return Math.max(nums[0], nums[1]);
            case 3:
                return Math.max(nums[0] + nums[2], nums[1]);
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        dp[2] = Math.max(nums[0] + nums[2], nums[1]);
        
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3]) + nums[i];
        }

        return Math.max(dp[n-1], dp[n-2]);
    }
}