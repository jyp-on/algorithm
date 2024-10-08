import java.math.*;
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double max = sum / k; 
        System.out.println(max);
        for (int i = k; i < nums.length; i++) {
            sum += (nums[i] - nums[i-k]);
            max = Math.max(max, sum / k);
            // System.out.printf("sum : %f, max : %f\n", sum, max);
        }

        return max;
    }
}