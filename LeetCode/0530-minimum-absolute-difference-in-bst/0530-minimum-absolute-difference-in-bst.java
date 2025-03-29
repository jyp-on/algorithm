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
    List<Integer> li;
    public int getMinimumDifference(TreeNode root) {
        li = new ArrayList<>();
        dfs(root);
        Collections.sort(li);

        int answer = Integer.MAX_VALUE;

        for(int i=1; i<li.size(); i++) {
            answer = Math.min(answer, li.get(i)-li.get(i-1));
        }
        
        return answer;
    }

    public void dfs(TreeNode node) {
        if(node==null) return;
        li.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
}