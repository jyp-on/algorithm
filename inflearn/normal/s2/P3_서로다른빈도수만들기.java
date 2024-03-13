package org.example.inflearn.normal.s2;
import java.util.*;
public class P3_서로다른빈도수만들기 {
    public int solution(String s){
        int answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : s.toCharArray()){
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        for(int i=0; i<s.length()-1; i++){
            if(!map.containsKey(s.charAt(i))) continue;
            int prev = map.get(s.charAt(i));

            for(int j=i+1; j<s.length(); j++){
                if(!map.containsKey(s.charAt(j))) continue;
                if(s.charAt(i)!=s.charAt(j)){
                    if(prev == map.get(s.charAt(j))) {
                        char cj = s.charAt(j);
                        map.put(cj, map.get(cj)-1);
                        answer++;
                        if(map.get(cj)==0) map.remove(cj);
                    }
                }
            }
        }
        return answer;
    }

    public int solution2(String s){
        int answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(char x : s.toCharArray()){
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        for(char key : map.keySet()){
            while(set.contains(map.get(key))){
                answer++;
                map.put(key, map.get(key)-1);
            }
            if(map.get(key)==0) continue;
            set.add(map.get(key));
        }
        return answer;
    }

    public static void main(String[] args){
        P3_서로다른빈도수만들기 T = new P3_서로다른빈도수만들기();
        System.out.println(T.solution2("aaabbbcc"));
        System.out.println(T.solution2("aaabbc"));
        System.out.println(T.solution2("aebbbbc"));
        System.out.println(T.solution2("aaabbbcccde"));
        System.out.println(T.solution2("aaabbbcccdddeeeeeff"));
    }
}
