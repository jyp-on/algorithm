package org.example.inflearn.basic.s5;

import java.util.*;

class Person {
    int id;
    int priority;
    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

public class P8_응급실 {
    // Queue
    public static int solution(int[] arr, int t_id) {
        int answer=0;
        Queue<Person> Q = new LinkedList<>();
        for(int i=0; i<arr.length; i++) Q.offer(new Person(i, arr[i]));
        while(!Q.isEmpty()) {
            Person polled = Q.poll();
            for(Person x : Q) {
                if(polled.priority < x.priority) {
                    Q.add(polled);
                    polled=null;
                    break;
                }
            }
            if(polled!=null) {
                if(polled.id==t_id) return ++answer;
                else answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i]=sc.nextInt();
        System.out.println(solution(arr,m));
    }
}
