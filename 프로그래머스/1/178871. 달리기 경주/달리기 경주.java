import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        for(int i = 0; i < callings.length; i++) {
            int rank = map.get(callings[i]); // 부른사람의 rank
            map.put(callings[i], rank-1);
            
            String forward = players[rank-1]; // 앞사람 이름
            map.put(forward, rank);
            
            // HashMap 뿐만아니라 실제 players의 순서도 바꿔줘야 함
            players[rank] = forward;
            players[rank-1] = callings[i];
        }
        
        return players;
    }
}