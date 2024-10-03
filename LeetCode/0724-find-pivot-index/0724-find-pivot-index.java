class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length <= 1) return 0;
        int lt_sum = nums[0], rt_sum = 0;

        // if pivot left
        for (int x : nums) rt_sum += x;
        rt_sum -= nums[0];
        if (rt_sum == 0) return 0;

        rt_sum -= nums[1];
        if (rt_sum == lt_sum) return 1;

        for (int i = 1; i < nums.length-1; i++) {
            lt_sum += nums[i];
            rt_sum -= nums[i+1];
            if (lt_sum == rt_sum) return i+1;
        }

        // if pivot right
        if (lt_sum == 0) return 0;

        return -1;
    }
}