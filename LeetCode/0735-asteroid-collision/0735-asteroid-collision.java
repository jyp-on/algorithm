import java.util.*;
import java.math.*;
class Solution {
    public int[] asteroidCollision(int[] aste) {
        int n = aste.length;
        int i = 0;
        while(i < n) {
            if(aste[i] < 0) {
                int j = i-1;
                while(j >= 0) {
                    if(aste[i] * aste[j] > 0) break;
                    int a = Math.abs(aste[i]);
                    int b = Math.abs(aste[j]);
                    if(a > b) {
                        aste[j] = 0;
                        j--;
                    } else if(a < b) {
                        aste[i] = 0;
                        break;
                    } else {
                        aste[i] = 0;
                        aste[j] = 0;
                        break;
                    }
                }
            }
            i++;
        }

        List<Integer> arr = new ArrayList<>();
        for(int x : aste) {
            if(x != 0) arr.add(x);
        }
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}