package org.example.inflearn.normal.s6;

import java.util.*;
class P4 {
    HashSet<String> set;
    int[] ch;
    String t;
    int m;
    boolean isPal(String s) {
        String tmp = "";
        for(int i = s.length()-1; i>=0; i--) {
            tmp += s.charAt(i);
        }
        return s.equals(tmp);
    }
    void DFS(int L, String str) {
        if(L==m) {
//            System.out.println(str);
            if(isPal(str)) set.add(str);
        } else {
            for(int i = 0; i < m; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    DFS(L+1, str + t.charAt(i));
                    ch[i] = 0;
                }
            }
        }
    }
    public String[] solution(String s){
        ch = new int[s.length()];
        m = s.length();
        t = s;
        set = new HashSet<>();
        DFS(0, "");
        String[] answer = new String[set.size()];
        int idx = 0;
        for(String x : set) answer[idx++] = x;
        return answer;
    }

    public static void main(String[] args){
        P4 T = new P4();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
}