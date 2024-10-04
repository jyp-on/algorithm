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
    public List<Integer> rightSideView(TreeNode root) {
        return bfs(root);
    }

    public List<Integer> bfs(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            ans.add(q.getLast().val);
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.pollFirst();
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
        }

        return ans;
    }
}