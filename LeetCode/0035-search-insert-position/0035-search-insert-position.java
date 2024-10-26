class Solution {
    public int searchInsert(int[] nums, int target) {
        int lt = 0, rt = nums.length-1;
        int mid_idx = 0;
        while(lt <= rt) {
            mid_idx = (lt+rt) / 2;
            int mid_val = nums[mid_idx];
            if(mid_val > target) rt = mid_idx - 1;
            else if(mid_val < target) lt = mid_idx + 1;
            else return mid_idx;
        }

        return lt;
    }
}