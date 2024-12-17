class Solution {
    public int jump(int[] nums) {
        int[] memo = new int[nums.length]; // i까지 가는데 최소비용
        boolean flag = false;
        for(int i=0; i<nums.length; i++) {
            if(flag) break;
            int p = nums[i];
            for(int j=i+1; j<Math.min(i+p+1, nums.length); j++) {
                if(memo[j] == 0) {
                    memo[j] = memo[i] + 1;
                } else {
                    memo[j] = Math.min(memo[i] + 1, memo[j]);
                }
                
                if(j == nums.length-1) {
                    flag = true;
                    break;
                }
            }
        }

        // for(int x : memo) System.out.print(x + " ");

        return memo[nums.length-1];
    }
}