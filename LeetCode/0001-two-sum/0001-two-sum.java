class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> hash = new HashMap<>();
        for(int i=0; i<n; i++) {
            hash.put(nums[i], i);
        }
        
        for(int i=0; i<n; i++) {
            int complement = target - nums[i];
            if(hash.containsKey(complement) && hash.get(complement) != i) {
                return new int[]{i, hash.get(complement)};
            }
        }

        return null;
    }
}