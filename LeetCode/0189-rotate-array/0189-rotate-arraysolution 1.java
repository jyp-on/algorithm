class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] temp = Arrays.copyOf(nums, n);
        int p = 0;
        for(int i=n-k; i<2*n-k; i++) {
            nums[p++] = temp[i%n];
        }
    }
}