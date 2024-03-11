package org.example.inflearn.practice;

import java.util.*;

public class Array {
    public static void main(String[] args){
        // int[] -> List<Integer>
        int[] arr = {1, 2, 3, 4, 5};
        List<Integer> list = new ArrayList<>();
        for(int x : arr) list.add(x);
        System.out.println(list);

        // List<Integer> -> int[]
        int[] newArr = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            newArr[i] = list.get(i);
        }
        for(int x : newArr) System.out.print(x+" ");
        System.out.println();

        // String -> char[]
        String s = "abcde";
        char[] c = s.toCharArray();
        for(char x : c) System.out.print(x+" ");
        System.out.println();

        // char[] -> String
        StringBuilder ss = new StringBuilder();
        for(char x : c) ss.append(x).append(" ");
        System.out.println(ss);
        ss.setLength(0);

        // String
        String sss = "abcdefghizklmnop";
        for(int i=0; i<sss.length(); i++){
            System.out.print(sss.charAt(i)+" ");
        }
    }
}
