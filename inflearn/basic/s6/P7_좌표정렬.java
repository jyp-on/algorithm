package org.example.inflearn.basic.s6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class Point implements Comparable<Point> {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point o) {
        if(this.x==o.x) return this.y-o.y;
        else return this.x-o.x;
    }
}

public class P7_좌표정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> points = new ArrayList<>();
        for(int i=0; i<n; i++) {
            points.add(new Point(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(points);
        for(Point p : points) {
            System.out.println(p.x + " " + p.y);
        }
    }
}
