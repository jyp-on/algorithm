import java.math.*;
class Solution {
    public int largestAltitude(int[] gain) {
        int sum = 0;
        int max = 0;
        for (int x : gain) {
            sum += x;
            max = Math.max(sum, max);
        }
        return max;
    }
}