// BST는 중위순회 돌면 오름차순 정렬 되어있는 트리임
class Solution {
    int minDiff = Integer.MAX_VALUE, prev = -1;
    
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left); // 왼쪽 서브트리 방문

        // 현재 값과 이전 값의 차이를 계산 (최소 차이 갱신)
        if (prev >= 0) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val; // 이전 값 업데이트

        inorder(node.right); // 오른쪽 서브트리 방문
    }

}