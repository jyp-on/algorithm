class Solution {
    TreeNode ans;
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) ans = root;
        searchBST(root.left, val);
        searchBST(root.right, val);
        return ans;
    }
}