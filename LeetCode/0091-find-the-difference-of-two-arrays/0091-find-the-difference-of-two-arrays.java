import java.util.*;
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int x : nums1) {
            set1.add(x);
        }
        for (int x : nums2) {
            set2.add(x);
        }

        boolean[] visited1 = new boolean[2001];
        for (int x : nums1) {
            if (!set2.contains(x) && !visited1[x+1000]) {
                visited1[x+1000] = true;
                ans1.add(x);
            }
        }

        boolean[] visited2 = new boolean[2001];
        for (int x : nums2) {
            if (!set1.contains(x) && !visited2[x+1000]) {
                visited2[x+1000] = true;
                ans2.add(x);
            }
        }

        ans.add(ans1);
        ans.add(ans2);

        return ans;
    }
}