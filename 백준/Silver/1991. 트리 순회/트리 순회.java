import java.util.*;
import java.io.*;

class Nodes {
    char lt, rt;
    public Nodes(char lt, char rt) {
        this.lt = lt;
        this.rt = rt;
    }
}

public class Main {
    static Map<Character, Nodes> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    static void preOrder(char root) {
        if(root == '.') return;
        Nodes nodes = map.get(root);

        System.out.print(root);
        preOrder(nodes.lt);
        preOrder(nodes.rt);
    }

    static void inOrder(char root) {
        if(root == '.') return;
        Nodes nodes = map.get(root);

        inOrder(nodes.lt);
        sb.append(root);
        inOrder(nodes.rt);
    }

    static void postOrder(char root) {
        if(root == '.') return;
        Nodes nodes = map.get(root);

        postOrder(nodes.lt);
        postOrder(nodes.rt);
        sb.append(root);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char lt = st.nextToken().charAt(0);
            char rt = st.nextToken().charAt(0);
            map.put(root, new Nodes(lt, rt));
        }

        preOrder('A');
        sb.append("\n");

        inOrder('A');
        sb.append("\n");

        postOrder('A');
        System.out.println(sb.toString());
    }
}
