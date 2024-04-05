import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> answer = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                int x = numbers[i] + numbers[j];
                if(set.contains(x)) continue;
                else {
                    answer.add(x);
                    set.add(x);
                }
            }
        }
        Collections.sort(answer);
        return answer.stream().mapToInt(i->i).toArray();
    }
}