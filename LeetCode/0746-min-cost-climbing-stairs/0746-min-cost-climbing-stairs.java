import java.math.*;
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] d = new int[cost.length];
        d[0] = cost[0];
        d[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            d[i] = Math.min(d[i-1], d[i-2]) + cost[i];
        }

        // for (int x : d) {
        //     System.out.print(x + " ");
        // }

        return Math.min(d[d.length-2], d[d.length-1]);
    }
}