class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int sum = brown + yellow;
        for(int col=3; col<sum; col++) {
            int row = sum / col;
            if((row-2) * (col-2) == yellow) {
                return new int[]{row, col};
            }
        }
        return answer;
    }
}