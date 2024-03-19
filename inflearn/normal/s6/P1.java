package org.example.inflearn.normal.s6;

import java.util.*;
class P1 {
    int answer, target, m;
    ArrayList<Integer> nums;
    boolean flag;
    int[] ch;
    public int solution(int n){
        answer = 0;
        flag = false;
        nums = new ArrayList<>();
        target = n;
        int tmp = n;
        while(tmp>0) {
            int t = tmp % 10;
            nums.add(t);
            tmp = tmp / 10;
        }
        nums.sort((a, b) -> a - b);
        m = nums.size();
        ch = new int[m];
        DFS(0, 0);
        if(flag == false) return -1;
        return answer;
    }
    public void DFS(int L, int number) {
        if(flag) return;
        if(L==m) {
            if(target < number) {
                answer = number;
                flag = true;
            }
        } else {
            for(int i = 0; i < m; i++) {
                if(ch[i]==0) {
                    ch[i] = 1;
                    DFS(L+1, number*10 + nums.get(i));
                    ch[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args){
        P1 T = new P1();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}
