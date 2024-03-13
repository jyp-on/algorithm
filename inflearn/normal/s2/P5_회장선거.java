package org.example.inflearn.normal.s2;
import java.util.*;
public class P5_회장선거 {
    public String solution(String[] votes, int k){
        // 추천 받은사람 : 추천 한사람
        HashMap<String, ArrayList<String>> voteMap = new HashMap<>();
        for(int i=0; i<votes.length; i++){
            String[] s = votes[i].split(" ");
            if(voteMap.containsKey(s[1])){
                voteMap.get(s[1]).add(s[0]);
            } else {
                ArrayList<String> tmp = new ArrayList<>();
                tmp.add(s[0]);
                voteMap.put(s[1], tmp);
            }
        }
        HashMap<String, Integer> pMap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(String key : voteMap.keySet()){
            if(voteMap.get(key).size()>=k){
                for(String p : voteMap.get(key)){
                    int v = pMap.getOrDefault(p, 0)+1;
                    pMap.put(p, v);
                    if(v > max) max = v;
                }
            }
        }
        ArrayList<String> canAns = new ArrayList<>();
        for(String key : pMap.keySet()){
            if(pMap.get(key)==max){
                canAns.add(key);
            }
        }
        Collections.sort(canAns);
        return canAns.get(0);
    }

    public static void main(String[] args){
        P5_회장선거 T = new P5_회장선거();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}
