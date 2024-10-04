class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        return list1.equals(list2);
    }

    private void dfs(TreeNode root, List<Integer> leafs) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            leafs.add(root.val);
        }

        dfs(root.left, leafs);
        dfs(root.right, leafs);
    }
}