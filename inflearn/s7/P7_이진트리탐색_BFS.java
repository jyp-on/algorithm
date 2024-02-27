package org.example.inflearn.s7;

import java.util.LinkedList;
import java.util.Queue;

public class P7_이진트리탐색_BFS {
    public static void BFS(Node node) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(node);
        int L=0;
        while(!Q.isEmpty()) {
            int len=Q.size();
            System.out.print("Level " + L + " -> ");
            for(int i=0; i<len; i++) {
                Node cur = Q.poll();
                System.out.print(cur.data+" ");
                if(cur.lt!=null) Q.offer(cur.lt);
                if(cur.rt!=null) Q.offer(cur.rt);
            }
            L+=1;
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        BFS(root);
    }
}
