
package org.example.inflearn.normal.s4;

import java.util.*;
class P7 {
    public int solution(int[][] meetings){
        int answer = 0; // 최대로 겹치는 회의 수
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i=0; i<meetings.length; i++){
            arr.add(new int[]{meetings[i][0], 1}); // 들어가는 시간
            arr.add(new int[]{meetings[i][1], 2}); // 나가는 시간
        }
        // 시간순 오름차순, 시간이 같으면 나가는거 오름차순
        arr.sort((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int cnt = 0;
        for(int i=0; i<arr.size(); i++){
            int[] meet = arr.get(i);
            if(meet[1] == 1) cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args){
        P7 T = new P7();
        System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
        System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}