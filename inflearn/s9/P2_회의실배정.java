package org.example.inflearn.s9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Room implements Comparable<Room>{
    int s, e;
    public Room(int s, int e){
        this.s=s;
        this.e=e;
    }

    @Override
    public int compareTo(Room r) {
        if(this.e==r.e){
            return this.s-r.s;
        }
        return this.e-r.e; // 끝나는시간 오름차순
    }
}

public class P2_회의실배정 {
    public static int solution(ArrayList<Room> rooms){
        int answer=0;
        int end=-1;
        for(Room r : rooms){
            if(r.s>=end){
                end=r.e;
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Room> rooms = new ArrayList<>();
        for(int i=0; i<n; i++){
            rooms.add(new Room(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(rooms);
        System.out.println(solution(rooms));
    }
}
