class Solution {
    TreeNode out;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return out;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return false;
        
        boolean a = dfs(root.left, p, q);
        boolean b = dfs(root.right, p, q);

        if(root.val == p.val || root.val == q.val) {
            if(a || b) out = root;
            return true;
        }

        if(a && b) {
            out = root;
        }

        return a || b;
    }
}