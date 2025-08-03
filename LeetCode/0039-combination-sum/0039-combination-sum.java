class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        bt(0, candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    void bt(int start, int[] candidates, int target, int sum, List<Integer> path, List<List<Integer>> ans) {
        if(sum > target) return;
        if(sum == target) {
            ans.add(new ArrayList<>(path));
        }
        
        
        for(int i=start; i<candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            bt(i, candidates, target, sum, path, ans);
            path.remove(path.size()-1);
            sum -= candidates[i];
        }
    }
}