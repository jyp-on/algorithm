import java.util.*;
class Solution {
    public int equalPairs(int[][] grid) {
        int ans = 0;
        List<List<Integer>> list = new ArrayList<>();

        for(int[] row : grid) {
            List<Integer> arr = new ArrayList<>();
            for(int r : row) arr.add(r);
            list.add(arr);
        }

        for(int i = 0; i < grid.length; i++) {
            List<Integer> arr = new ArrayList<>();

            for(int j = 0; j < grid.length; j++) {
                arr.add(grid[j][i]);
            }

            for(List<Integer> row : list) {
                if(row.equals(arr)) ans++;
            }
        }

        return ans;
    }
}