import java.math.*;
class Solution {
    public int longestOnes(int[] nums, int k) {
        int result = 0;
        int left = 0;
        int zero = 0;
        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) {
                zero++;
                while(zero > k) {
                    int val = nums[left++];
                    if(val == 0) zero--;
                }
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}