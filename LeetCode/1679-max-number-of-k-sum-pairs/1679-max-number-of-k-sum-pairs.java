import java.util.*;
class Solution {
    public int maxOperations(int[] nums, int k) {
        int cnt = 0;
        Arrays.sort(nums);
        int lt = 0, rt = nums.length-1;
        while(lt < rt) {
            int sum = nums[lt] + nums[rt];
            if(sum == k) {
                cnt++; lt++; rt--;  
            }  
            else if (sum < k) lt++;
            else rt--;
        }

        return cnt;
    }
}