import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        List<String[]> arr = new ArrayList<>(); // id 별 state
        List<String> answer = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>(); // id : nickname
        for(String r : record) {
            String state = "", id = "", nickname = "";
            if(r.contains("Leave")) {
                state = r.split(" ")[0];
                id = r.split(" ")[1];
                arr.add(new String[]{id, state});
            } else {
                state = r.split(" ")[0];
                id = r.split(" ")[1];
                nickname = r.split(" ")[2];
                if(state.equals("Enter")) { // 방에 들어왔으면 id별 nickname 최신화 및 정답List에 상태 추가
                    map.put(id, nickname);
                    arr.add(new String[]{id, state});
                } else { // Change 면 map만 최신화
                    map.put(id, nickname);
                }
            }
        }
        for(String[] x : arr) {
            String nickname = map.get(x[0]);
            String state = x[1];
            if(state.equals("Enter")) answer.add(nickname + "님이 들어왔습니다.");
            else answer.add(nickname + "님이 나갔습니다.");
        }
        return answer.toArray(String[]::new);
    }
}