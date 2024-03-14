package org.example.inflearn.normal.s2;
import java.util.*;
public class P7_경고메일 {
    public int parseTime(String time){
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[1]);
        return h*60 + m;
    }
    public String[] solution(String[] reports, int time){
        String[] answer = {};
        ArrayList<String> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> totalT = new HashMap<>();

        for(String report : reports){
            String[] r = report.split(" ");
            String n = r[0];
            int t = parseTime(r[1]);
            String state = r[2];

            if(state.equals("in")) map.put(n, t);
            else { // 나가는 경우
                totalT.put(n, totalT.getOrDefault(n, 0) + t-map.get(n));
                map.remove(n);
            }
//            System.out.println(totalT);
        }
        for(String key : totalT.keySet()){
            if(totalT.get(key)>time) ans.add(key);
        }
        Collections.sort(ans);
        answer = new String[ans.size()];
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }

    public static void main(String[] args){
        P7_경고메일 T = new P7_경고메일();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}
