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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = dfs(root1, new ArrayList<Integer>());
        List<Integer> list2 = dfs(root2, new ArrayList<Integer>());
        return list1.equals(list2);
    }

    public List<Integer> dfs(TreeNode root, List<Integer> leafs) {
        if (root == null) {
            return leafs;
        }

        if (root.left == null && root.right == null) {
            leafs.add(root.val);
        }

        dfs(root.left, leafs);
        dfs(root.right, leafs);
        
        return leafs;
    }
}