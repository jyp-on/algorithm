class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] visit = new boolean[n];
        visit[0] = true;
        if(n==1) return true;
        for(int i=0; i<n; i++) {
            if(!visit[i]) continue;
            for(int j=i; j<=Math.min(i+nums[i], n-1); j++) {
                visit[j] = true;
                if(j == n-1) return true;
            }
        }

        return false;
    }
}