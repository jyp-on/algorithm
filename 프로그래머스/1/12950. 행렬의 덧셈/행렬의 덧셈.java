class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row_max = arr1.length;
        int col_max = arr1[0].length;
        int[][] answer = new int[row_max][col_max];
        for(int r = 0; r < row_max; r++) {
            for(int c = 0; c < col_max; c++) {
                answer[r][c] = arr1[r][c] + arr2[r][c];
            }
        }
        return answer;
    }
}