import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[]{-1};
        int minValue = Integer.MAX_VALUE;
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i : arr) if(i < minValue) minValue = i;
        for(int i : arr) if(i != minValue) answer.add(i);
        return answer.stream()
            .mapToInt(i->i).toArray();
    }
}