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
    int ans, cur;
    boolean flag;
    public int kthSmallest(TreeNode root, int k) {
        ans = 0;
        cur = 0;
        flag = false;
        inorder(root, k);
        return ans;
    }

    public void inorder(TreeNode node, int k) {
        if(flag || node == null) return;

        inorder(node.left, k);

        cur++;
        if(cur == k) {
            ans = node.val;
            flag = true;
        }

        inorder(node.right, k);
    }
}