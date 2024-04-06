import java.util.*;
class Solution {
    static boolean[] visited;
    static int depth;
    
    public void open(int x, int[] cards) { // x : 상자 번호 
        if(!visited[x]) {
            visited[x] = true;
            depth++;
            open(cards[x-1], cards);
        }
    }
    
    public int solution(int[] cards) {
        List<Integer> list = new ArrayList<>();
        int n = cards.length;
        visited = new boolean[n+1];
        for(int i = 0; i < n; i++) {
            if(!visited[i+1]) {
                depth = 1;
                visited[i+1] = true;
                open(cards[i], cards);        
                list.add(depth);
            }
        } 
        if(list.size()==1) return 0;
        list.sort((a, b) -> b - a);
        return list.get(0) * list.get(1);
    }
}