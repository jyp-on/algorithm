package org.example.inflearn.normal.s3;
import java.util.*;
public class P6 {
    public int solution(int n, int[][] meetings){
        int[] ch = new int[n]; // 각 회의실이 몇번 사용됬는지
        int len = meetings.length;
        // 시작시간, 끝나는시간
        LinkedList<int[]> meeting = new LinkedList<>();
        for(int i=0; i<len; i++){
            meeting.add(new int[]{meetings[i][0], meetings[i][1]});
        }
        // 시작순서 오름차순 정렬
        Collections.sort(meeting, (a, b) -> a[0] - b[0]);
        // 끝나는시간, 방번호 (끝나는시간 오름차순, 방번호 오름차순)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] room = new int[n]; // 현재 방이 사용중인지 (사용중이면 1, 아니면 0)
        int[] prevT = new int[n]; // 각 방의 직전 회의가 끝나는시간
        for(int t = 0; t<=500000; t++){
            while(!meeting.isEmpty() && pq.size()<n){
                if(meeting.peek()[0]>=t) { // 시작시간이 되면 회의실 들어가기
                    int[] m = meeting.pollFirst();
                    for(int i=0; i<n; i++){ // 빈방 중 번호가 낮은 방부터 들어가기
                        if(room[i]==0){
                            pq.offer(new int[]{prevT[i] + m[1]-m[0], i}); // 이전 회의 끝난시간 + 내가 사용하는시간
                            prevT[i] += m[1];
                            room[i] = 1; // 사용중인 방으로 체크
                            ch[i]++;
                            break;
                        }
                    }
                } else break;
            }
            // 끝나는시간이 되면 꺼내기
            if(!pq.isEmpty() && pq.peek()[0]>=t){
                int[] p = pq.poll();
                room[p[1]] = 0; // 회의 끝나면 빈방으로 체크
            }
        }

        int max = -1;
        for(int i=0; i<n; i++) if(max<ch[i]) max = ch[i];
        for(int i=0; i<n; i++) if(ch[i]==max) return i;
        return -1;
    }

    public static void main(String[] args){
        P6 T = new P6();
        System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    }
}
