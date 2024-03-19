package org.example.inflearn.practice;

import java.util.*;
import java.io.*;
public class GCD_LCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("gcd : " + gcd(a, b));
        System.out.println("lcm : " + a * b / gcd(a, b));
    }
    public static int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}
