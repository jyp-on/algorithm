package org.example.inflearn.practice;


public class Ascii {
    public static void main(String[] args){
        // 대문자 아스키
        for(int i=65; i<=90; i++) {
            System.out.print((char) i + " ");
        }
        System.out.println();

        // 소문자 아스키
        for(int i=97; i<=122; i++) {
            System.out.print((char) i + " ");
        }

    }
}
