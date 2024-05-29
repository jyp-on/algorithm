import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] bookTime = new int[book_time.length][2];
        
        for (int i = 0; i<book_time.length; i++) {
            int start = Integer.parseInt(book_time[i][0].replace(":", ""));
            int end = Integer.parseInt(book_time[i][1].replace(":", ""));
            
            end += 10; // 청소 시간
            
            if (end % 100 >= 60) {
                end += 40;
            }
            
            bookTime[i][0] = start;
            bookTime[i][1] = end;
            
        }
        
        Arrays.sort(bookTime, (a1, a2) -> a1[0] - a2[0]); // 시작시간 기준
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // 끝나는시간 기준
        for (int[] book : bookTime) {
            
            if (pq.isEmpty()) { // 방이 비어있다면 
                pq.add(book);
            } else {
                int[] tmp = pq.peek(); // 가장 빨리 끝나는 방
                int start = tmp[0];
                int end = tmp[1];
                
                if (book[0] >= end) { // 대실이 끝난 경우 그대로 사용가능
                    pq.poll();
                }
                
                pq.add(book);
            }
            
        }

        answer = pq.size();
        return answer;
    }
}