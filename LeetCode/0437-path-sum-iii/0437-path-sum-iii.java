class Solution {
    int cnt;
    public int pathSum(TreeNode root, int targetSum) {
        cnt = 0;
        if (root == null) return 0;
        dfs(root, targetSum, new long[1000], 0);
        return cnt;
    }

    public void dfs(TreeNode root, int targetSum, long[] path, int level) {
        if (root == null) return;

        path[level] = root.val;
        long sum = 0;

        for (int i = level; i >= 0; i--) {
            sum += path[i];
            if (sum == targetSum) cnt++;
        }

        dfs(root.left, targetSum, path, level+1);
        dfs(root.right, targetSum, path, level+1);
    }
}