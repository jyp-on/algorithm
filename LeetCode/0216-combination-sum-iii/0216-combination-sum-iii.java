class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answer = new ArrayList<>();
        bt(1, 0, k, n, new ArrayList<>(), answer);
        return answer;
    }

    void bt(int start, int sum, int k, int n, List<Integer> path, List<List<Integer>> answer) {
        if(sum == n && path.size() == k) {
            answer.add(new ArrayList<>(path));
            return;
        }

        if(sum > n) return;

        for(int i=start; i<10; i++) {
            int nextSum = sum+i;
            if(nextSum > n) break;
            if(path.size()+1 > k) break;

            path.add(i);
            bt(i+1, nextSum, k, n, path, answer);
            path.remove(path.size()-1);
        }
    }
}