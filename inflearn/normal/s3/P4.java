package org.example.inflearn.normal.s3;
import java.util.*;

public class P4 {
    public int parseTime(String time){
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[1]);
        return h*60 + m;
    }
    public int solution(int[] laser, String[] enter){
        int answer = 0;
        int n = enter.length;
        int[] time = new int[n];
        int[] l = new int[n];
        for(int i=0; i<n; i++){
            time[i] = parseTime(enter[i].split(" ")[0]);
            l[i] = Integer.parseInt(enter[i].split(" ")[1]);
        }
        Queue<Integer> Q = new LinkedList<>();
        int ft = time[0], pos = 1;
        Q.offer(l[0]);
        for(int t=ft; t<=1200; t++){
            if(pos < n && t == time[pos]){
                // 대기실이 비어있고 다음차례 손님의 예약시간이 ft보다 크면 시간 건너뛰기
                if(Q.isEmpty() && time[pos] > ft) ft = time[pos];
                Q.offer(l[pos]);
                pos++;
            }
            if(ft==t && !Q.isEmpty()){
                ft += laser[Q.poll()];
            }
//            System.out.println(ft + " " + t);
            answer = Math.max(answer, Q.size());
        }
        return answer;
    }

    public static void main(String[] args){
        P4 T = new P4();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
        System.out.println(T.solution(new int[]{50, 10, 25, 15}, new String[]{"10:00 0", "10:10 1", "10:21 1", "10:31 1"}));
    }
}
