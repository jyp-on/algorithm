import java.util.*;
public class Main {
    static int[] unf;
    public static boolean isSameParent(int a, int b) {
        a = find(a);
        b = find(b);
        return a == b;
    }
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) unf[a] = b;
    }
    public static int find(int x) {
        if(unf[x] == x) return x;
        else return unf[x] = find(unf[x]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n+1];
        for(int i = 0; i <= n; i++) unf[i] = i;
        for(int i = 0; i < m; i++) {
            int op = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(op == 0) union(a, b);
            else {
                if(isSameParent(a, b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}
