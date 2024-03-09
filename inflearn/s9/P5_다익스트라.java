package org.example.inflearn.s9;

import java.util.*;
class Edge implements Comparable<Edge>{
    int v;
    int cost;
    public Edge(int v, int cost){
        this.v=v;
        this.cost=cost;
    }

    @Override
    public int compareTo(Edge ob){
        return this.cost-ob.cost;
    }
}
public class P5_다익스트라 {
    static int n, m;
    static int[] dist;
    static ArrayList<ArrayList<Edge>> graph;
    public static void solution(int v){
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v, 0));
        dist[v]=0;
        while(!pQ.isEmpty()){
            Edge tmp = pQ.poll();
            int now = tmp.v;
            int nowCost = tmp.cost;
            if(nowCost>dist[now]) continue;
            for(Edge ob : graph.get(now)){
                if(dist[ob.v]>nowCost+ob.cost){
                    dist[ob.v]=nowCost+ob.cost;
                    pQ.offer(new Edge(ob.v, nowCost+ob.cost));
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        graph=new ArrayList<ArrayList<Edge>>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Edge>());
        }
        for(int i=0; i<=n; i++){
            // a 정점에서 b 정점으로가는 cost
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            graph.get(a).add(new Edge(b, c));
        }
        solution(1);
        for(int i=2; i<=n; i++){
            if(dist[i]!=Integer.MAX_VALUE) System.out.println(i+" : "+dist[i]);
            else System.out.println("impossible");
        }
    }
}
