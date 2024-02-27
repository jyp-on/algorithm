package org.example.inflearn.s7;

import java.util.LinkedList;
import java.util.Queue;

public class P9_말단노드최단거리_BFS {
    public static int BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L=0;

        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i=0; i<len; i++) { // 레벨 순회
                Node node = Q.poll();
                if(node.lt==null && node.rt==null) return L;
                if(node.lt!=null) Q.offer(node.lt);
                if(node.rt!=null) Q.offer(node.rt);
            }
            L++;
        }
        return 0;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        System.out.println(BFS(root));
    }
}
