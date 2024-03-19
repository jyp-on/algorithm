package org.example.inflearn.normal.s6;

import java.util.*;
class P6 {
    int[] dy;
    public int DFS(int start, String s){
        if(dy[start] > 0) return dy[start]; // 기존에 저장되있으면 바로 return
        if(start < s.length() && s.charAt(start) == '0') return 0; // 0으로 시작하는건 없음
        if(start == s.length() -1 || start == s.length()) return 1; // 마지막 2개 or 1개인 경우는 1가지뿐
        else{
            int res = DFS(start + 1, s);
            int tmp = Integer.parseInt(s.substring(start, start + 2));
            if(tmp <= 26) res += DFS(start + 2, s);
            return dy[start] = res;
        }
    }

    public int solution(String s){
        dy = new int[101];
        int answer = DFS(0, s);
        return answer;
    }

    public static void main(String[] args){
        P6 T = new P6();
        System.out.println(T.solution("25114"));
        System.out.println(T.solution("23251232"));
        System.out.println(T.solution("21020132"));
        System.out.println(T.solution("21350"));
        System.out.println(T.solution("120225"));
        System.out.println(T.solution("232012521"));
    }
}