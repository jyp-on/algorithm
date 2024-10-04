import java.util.*;
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];
        for (int x : arr) {
            count[x+1000] += 1;
        }

        Set<Integer> set = new HashSet<>();
        for (int x : count) {
            if (x != 0) {
                if (set.contains(x)) {
                    return false;
                }
                set.add(x);
            }
        }

        return true;
    }
}