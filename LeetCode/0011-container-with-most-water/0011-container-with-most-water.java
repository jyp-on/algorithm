import java.math.*;
class Solution {
    public int maxArea(int[] height) {
        int answer = -1;
        int lt = 0, rt = height.length-1;
        while(lt < rt) {
            int h = Math.min(height[lt], height[rt]);
            int w = rt - lt;
            answer = Math.max(h * w, answer);
            if(height[lt] > height[rt]) rt--;
            else lt++;
        }

        return answer;
    }
}