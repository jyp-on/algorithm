import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        Arrays.sort(stages);
        int[] fail = new int[N+1]; // 스테이지별 클리어 한 사람의 수
        for(int i = 0; i < stages.length; i++) {
            if(stages[i] == N+1) continue;
            else fail[stages[i]]++;
        }
        // for(int x : clear) System.out.print(x + " ");
        int len = stages.length; // 사람 수
        HashMap<Integer, Double> map = new HashMap<>(); // 스테이지 : 실패율
        for(int i = 1; i < fail.length; i++) {
            if(len == 0 || fail[i] == 0) map.put(i, 0.0);
            else map.put(i, (double)fail[i] / len); // i번 스테이지의 실패율
            len -= fail[i];
        }
        List<Integer> answer = new ArrayList<>(map.keySet());
        // value(실패율)이 같으면 stage 오름차순, 다르면 실패율 내림차순
        Collections.sort(answer, (a, b) -> map.get(a) == map.get(b) ? a - b : map.get(b).compareTo(map.get(a)));
        return answer.stream().mapToInt(i->i).toArray();
    }
}