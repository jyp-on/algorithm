class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0, cnt=1;
        for(int j=1; j<nums.length; j++) {
            if(nums[i] != nums[j]) {
                nums[++i] = nums[j];
                cnt=1;
            }

            else if(nums[i] == nums[j] && cnt<2) {
                nums[++i] = nums[j];
                cnt++;
            }
        }

        return i+1;
    }
}