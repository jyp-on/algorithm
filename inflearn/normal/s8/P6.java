
package org.example.inflearn.normal.s8;

import java.util.*;
class P6 {
    ArrayList<String> answer;
    HashMap<String, HashSet<String>> courseMap;
    HashMap<String, Integer> ch; // 이수한 과목인지
    void DFS(String subject) {
        if(ch.getOrDefault(subject, 0) == 0) { // 안들은 과목이면
            if(courseMap.getOrDefault(subject, new HashSet<>()).size() != 0) {
                for(String s : courseMap.get(subject)) { // 선수과목 중에 안들은게 있으면 듣기
                    DFS(s);
                }
            }
            // 선수과목 다 들었으면 체크
            ch.put(subject, ch.getOrDefault(subject, 0) + 1);
            answer.add(subject);
        }
    }
    public ArrayList<String> solution(String[] subjects, String[] course){
        answer = new ArrayList<>();
        int n = subjects.length;
        int m = course.length;
        // 이수한 과목인지
        ch = new HashMap<>();
        // 해당과목을 듣기 위해 들어야하는 선수과목 Set
        courseMap = new HashMap<>();
        for(int i = 0; i < m; i++) {
            String a = course[i].split(" ")[0];
            String b = course[i].split(" ")[1];
            courseMap.putIfAbsent(a, new HashSet<String>());
            courseMap.get(a).add(b);
        }
        for(int i = 0; i < n; i++) {
            DFS(subjects[i]);
        }
        return answer;
    }

    public static void main(String[] args){
        P6 T = new P6();
        System.out.println(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"}));
        System.out.println(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"}));
        System.out.println(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"}));
    }
}