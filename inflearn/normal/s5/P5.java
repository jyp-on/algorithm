package org.example.inflearn.normal.s5;

import java.util.*;
import java.util.Map.Entry;

class P5 {
    class Pair{
        int idx;
        String team;
        int attack;
        public Pair(int idx, String team, int attack){
            this.idx = idx;
            this.team = team;
            this.attack = attack;
        }
    }
    public int[] solution(String[] students){
        int n = students.length;
        int[] answer = new int[n];
        ArrayList<Pair> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String[] split = students[i].split(" ");
            arr.add(new Pair(i, split[0], Integer.parseInt(split[1])));
        }
        // 공격력 작은 순서대로
        arr.sort((a, b) -> a.attack - b.attack);
//        for(Pair p : arr) {
//            System.out.println(p.idx + " " + p.team + " " + p.attack);
//        }
        HashMap<String, Integer> map = new HashMap<>();
        int j = 0, sum = 0;
        for(int i = 1; i < arr.size(); i++) {
            for(; j < n; j++) {
                if(arr.get(j).attack < arr.get(i).attack) {
                    sum += arr.get(j).attack;
                    String team = arr.get(j).team;
                    map.put(team, map.getOrDefault(team, 0) + arr.get(j).attack);
                } else break;
            }
            answer[arr.get(i).idx] = sum - map.getOrDefault(arr.get(i).team, 0);
        }

        return answer;
    }

    public static void main(String[] args){
        P5 T = new P5();
        System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }
}