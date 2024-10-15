import java.util.*;
import java.math.*;
class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        int maxLevel = 0;
        int maxSum = Integer.MIN_VALUE;

        while(!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            level++;

            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                sum += cur.val;
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }

            if(sum > maxSum) {
                maxSum = sum;
                maxLevel = level;
            }
        }
        

        return maxLevel;
    }
}