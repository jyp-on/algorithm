package org.example.inflearn.practice;

public class Parse {
    public static void main(String[] args){
        String s = "1 2 3 4 5 6";
        String[] split = s.split(" ");
        int sum=0;
        for(String x : split) {
            sum+=Integer.parseInt(x);
        }
        System.out.println(sum);


    }
}
