import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        if(x==y) return 0; // 이거 때문에 애먹음..
        Queue<Integer> Q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Q.offer(x);
        int L = 1;
        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i=0; i<len; i++) { // 레벨 탐색
                int cur = Q.poll();
                for(int next : new int[]{cur+n, cur*2, cur*3}) {
                    // System.out.println(L + " " + next);
                    if(visited.contains(next)) continue;
                    if(next == y) return L;
                    if(next < y) {
                        Q.offer(next);
                        visited.add(next);
                    }
                }
            }
            L++;
        }
        return -1;
    }
}