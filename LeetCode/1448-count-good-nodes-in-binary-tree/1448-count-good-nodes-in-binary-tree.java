/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;
class Solution {
    int answer;
    public int goodNodes(TreeNode root) {
        answer = 0;
        dfs(root, root.val);
        return answer;
    }

    public void dfs(TreeNode root, int max) {
        if (root == null) return;

        if (root.val >= max) {
            answer++;
            max = Math.max(max, root.val);
        }

        dfs(root.left, max);
        dfs(root.right, max);
    }
}