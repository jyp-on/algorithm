import java.io.*;
import java.util.*;

public class Main {
    static int K, size;
    static int[] num;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = (int)(Math.pow(2, K) - 1); // 노드의 전체 개수
        tree = new ArrayList[K+1];
        num = new int[size+1];
        for(int i=0;i<=K;i++)
            tree[i] = new ArrayList<>();
        int index = 1;
        while(st.hasMoreTokens())
            num[index++] = Integer.parseInt(st.nextToken());

        // 중위 순회
        search(1, 1, size);

        // 출력
        for(int i=1;i<=K;i++){
            for(int j=0;j<tree[i].size();j++)
                sb.append(tree[i].get(j) + " ");
            sb.append("");
        }
        System.out.println(sb.toString());
    }

    static void search(int depth, int start, int end){
        int mid = (start + end)/2; // 중앙 (부모)
        tree[depth].add(num[mid]);
        if(depth == K)
            return;
        search(depth+1, start, mid-1);
        search(depth+1, mid+1, end);
    }
}