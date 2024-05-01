

import java.util.*;

public class Main {
    static class Room implements Comparable<Room> {
        int s, e;
        public Room(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Room o) {
            if(this.s == o.s) return this.e - o.e;
            return this.s - o.s;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Room> rooms = new ArrayList<>();
        for(int i=0; i<N; i++) {
            rooms.add(new Room(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(rooms);
        // 사용중인 회의실 pq를 끝나는시간 오름차순
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(rooms.get(0).e);

        for(int i=1; i<rooms.size(); i++) {
            // 가장 빨리 끝나는 시각과 다음 강의 시작시간을 비교
            if(pq.peek() <= rooms.get(i).s) {
                pq.poll(); // 이미 회의가 끝난 강의실이니 pop
            }
            pq.offer(rooms.get(i).e); // 회의를 진행해야 하니 offer
        }

        System.out.println(pq.size()); // 사용중인 회의실 개수
    }
}