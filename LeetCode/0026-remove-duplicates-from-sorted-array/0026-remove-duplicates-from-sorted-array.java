class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0, n=nums.length;

        for(int j=1; j<n; j++) {
            if(nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}