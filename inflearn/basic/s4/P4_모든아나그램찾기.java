package org.example.inflearn.basic.s4;

import java.util.HashMap;
import java.util.Scanner;

public class P4_모든아나그램찾기 {
    public static boolean isAnagram(HashMap<Character,Integer> map1, HashMap<Character,Integer> map2) {
        for(char x :map1.keySet()) {
            if(map2.containsKey(x)) {
                if(map1.get(x)!=map2.get(x)) return false;
            } else return false;
        }
        return true;
    }
    public static int solution(String a, String b) {
        int answer = 0;
        char[] arr = a.toCharArray();
        char[] target = b.toCharArray();
        HashMap<Character,Integer> map1 = new HashMap<>();
        for(char x : target) map1.put(x, map1.getOrDefault(x, 0)+1);
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(int i=0; i<target.length; i++) map2.put(arr[i], map2.getOrDefault(arr[i], 0)+1);
        if(isAnagram(map1, map2)) answer++;

        int p1=0, p2=target.length;
        while(p2<a.length()) {
            map2.put(arr[p2], map2.getOrDefault(arr[p2],0)+1);
            map2.put(arr[p1], map2.get(arr[p1])-1);
            if(map2.get(arr[p1])==0) map2.remove(arr[p1]);
            if(isAnagram(map1, map2)) answer++;
            p1++; p2++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(solution(a,b));
    }
}
