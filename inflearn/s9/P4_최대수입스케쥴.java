package org.example.inflearn.s9;

import java.util.*;

class Lecture implements Comparable<Lecture>{
    int money;
    int time;
    public Lecture(int money, int time){
        this.money=money;
        this.time=time;
    }
    public int compareTo(Lecture ob){
        return ob.time - this.time;
    }
}

public class P4_최대수입스케쥴 {
    static int n, max=Integer.MIN_VALUE;
    public static int solution(ArrayList<Lecture> arr){
        int answer=0;
        PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder()); // 가장 큰 값부터 꺼내줌
        Collections.sort(arr);
        int j=0;
        for(int i=max; i>=1; i--) {
            for( ; j<n; j++) {
                if(arr.get(j).time<i) break;
                PQ.offer(arr.get(j).money);
            }
            if(!PQ.isEmpty()) {
                int v = PQ.poll();
                answer += v;
//                System.out.println(v);
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            arr.add(new Lecture(m, d));
            if(d>max) max=d;
        }
        System.out.println(solution(arr));
    }
}