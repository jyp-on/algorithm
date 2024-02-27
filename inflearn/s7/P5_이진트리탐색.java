package org.example.inflearn.s7;

class Node {
    int data;
    Node lt, rt;
    public Node(int data) {
        this.data = data;
        lt=rt=null;
    }
}

public class P5_이진트리탐색 {
    public static void dfs(Node node) {
        if(node==null) return;
        else {
//            System.out.print(node.data+" "); // 전위 순회
            dfs(node.lt);
//            System.out.print(node.data+" "); // 중위 순회
            dfs(node.rt);
            System.out.print(node.data+" "); //  후위 순회
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
        dfs(root);
    }
}
