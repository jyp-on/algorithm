class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] visited = new boolean[21];
        bt(visited, nums, new ArrayList<>(), answer);
        return answer;
    }

    void bt(boolean[] visited, int[] nums, List<Integer> path, List<List<Integer>> answer) {
        if(path.size() == nums.length) {
            answer.add(new ArrayList<>(path));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(visited[nums[i] + 10]) {
                continue;
            }

            visited[nums[i] + 10] = true;
            path.add(nums[i]);
            bt(visited, nums, path, answer);
            path.remove(path.size()-1);
            visited[nums[i] + 10] = false;
        }
    }
}