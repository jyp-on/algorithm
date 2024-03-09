package org.example.inflearn.s10;

import java.util.*;
class Brick implements Comparable<Brick>{
    int s;
    int h;
    int w;
    public Brick(int s, int h, int w){
        this.s=s;
        this.h=h;
        this.w=w;
    }
    @Override
    public int compareTo(Brick ob){
        if(ob.s==this.s){
            return ob.w-this.w;
        }
        return ob.s-this.s; // 넓이 오름차순
    }
}
public class P4_가장높은탑쌓기 {
    static int[] dp; // 최대높이 DP
    public static int solution(ArrayList<Brick> arr){
        int answer;
        Collections.sort(arr); // 넓이 내림차순 정렬
        dp[0]=arr.get(0).h;
        answer=dp[0];
        for(int i=1; i<arr.size(); i++){
            int max_h=0;
            for(int j=i-1; j>=0; j--){
                Brick bi=arr.get(i); // 새로 올라갈 벽돌
                Brick bj=arr.get(j); // 밑에 있는 벽돌
                if(bj.w>bi.w && dp[j]>max_h) {
                    max_h=dp[j];
                }
            }
            dp[i]=max_h+arr.get(i).h;
            answer=Math.max(answer, dp[i]);
        }
        return answer;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Brick> arr = new ArrayList<>();
        dp=new int[n];
        for(int i=0; i<n; i++){
            arr.add(new Brick(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        System.out.println(solution(arr));
    }
}
