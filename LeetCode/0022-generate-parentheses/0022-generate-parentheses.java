class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtracking(n, 0, 0, new StringBuilder(), ans);
        return ans;
    }

    private void backtracking(int n, int open, int close, StringBuilder sb, List<String> ans) {
        // 유효한 조합 완성 시 추가
        if (sb.length() == n * 2) {
            ans.add(sb.toString());
            return;
        }

        // 여는 괄호는 n개까지 추가 가능
        if (open < n) {
            sb.append('(');
            backtracking(n, open + 1, close, sb, ans);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }

        // 닫는 괄호는 여는 괄호 수보다 많으면 안 됨
        if (close < open) {
            sb.append(')');
            backtracking(n, open, close + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }
    }
}
