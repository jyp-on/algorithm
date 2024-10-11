class Solution {
    public int longestSubarray(int[] nums) {
        int answer = 0;
        int left = 0;
        int zero = 0;
        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) zero++;
            while(zero > 1) {
                int val = nums[left++];
                if(val == 0) zero--;
            }

            answer = Math.max(answer, right - left);
        }

        return answer;
    }
}