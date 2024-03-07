package org.example.inflearn.s9;

import java.util.*;
import java.io.*;

class Time implements Comparable<Time>{
    int time;
    char state; // s e
    public Time(int time, char state) {
        this.time=time;
        this.state=state;
    }
    public int compareTo(Time t){
        if(this.time==t.time){ // e가 먼저 와야되니 오림차순
            return this.state-t.state;
        }
        return this.time-t.time;
    }
}
public class P3_결혼식 {
    public static int solution(List<Time> times){
        int answer=Integer.MIN_VALUE;
        int cnt=0;
        for(Time ob : times){
            if(ob.state=='s') cnt++;
            else cnt--;
            answer=Math.max(answer, cnt);
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        List<Time> times = new ArrayList<>();
        for(int i=0; i<n; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            times.add(new Time(s, 's'));
            times.add(new Time(e, 'e'));
        }
        Collections.sort(times);
        System.out.println(solution(times));
    }
}
