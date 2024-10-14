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
class Solution {
    int answer;
    public int longestZigZag(TreeNode root) {
        answer = 0;
        dfs(root.left, 0, 1);
        dfs(root.right, 1, 1);
        return answer;
    }

    // left == 0
    // right == 1
    public void dfs(TreeNode root, int prev, int depth) {
        if(root == null) {
            answer = Math.max(answer, depth-1);
            return;
        }

        if(prev == 0) {
            dfs(root.right, 1, depth+1);
            dfs(root.left, 0, 1);
        }
        else if(prev == 1) {
            dfs(root.left, 0, depth+1);
            dfs(root.right, 1, 1);
        }
        
    }
}