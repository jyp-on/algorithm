class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);
        // 1, 1, 2, 5, 6, 7, 10
        bt(0, 0, candidates, target, new ArrayList<>(), answer);
        return answer;
    }

    void bt(int start, int sum, int[] candidates, int target, List<Integer> path, List<List<Integer>> answer) {
        // System.out.printf("start: %d, sum: %d, path: [", start, sum);
        // for(int i : path) {
        //     System.out.printf("%d, ", i);
        // }
        // System.out.println("]");

        if(sum > target) return;
        if(sum == target) {
            answer.add(new ArrayList<>(path));
            return;
        }

        for(int i=start; i<candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i-1]) continue; // 중복된 값은 바로 넘어가기
            if(sum + candidates[i] > target) break; // candidates는 이미 정렬되었기 때문에 한번 target을 넘으면 뒤를 볼 필요 없음

            path.add(candidates[i]);
            bt(i+1, sum + candidates[i], candidates, target, path, answer);
            path.remove(path.size()-1);
        }
    }

    // start 0
    // path.add(1);
    // start, sum, path
    // bt(1, 1, [1])

    // start 1
    // path.add(1);
    // bt(2, 2, [1, 1])

    // start 2
    // path.add(2)
    // bt(3, 4, [1, 1, 2])

    // start 3
    // path.add(5)
    // bt(4, 9, [1, 1, 2, 5])

    // start 3
    // path.add(7)
    // bt(4, 11, [1, 1, 2, 7])

    // start 3
    // path.add(7)
    // bt(4, 14, [1, 1, 2, 10])

    // start 3
    // path.add(7)
    // bt(4, 14, [1, 1, 2, 10])

    // 
}