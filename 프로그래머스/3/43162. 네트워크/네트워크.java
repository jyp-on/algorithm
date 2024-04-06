class Solution {
    static int[] unf;
    
    public boolean isSameNetwork(int a, int b) {
        a = find(a);
        b = find(b);
        return a == b ? true : false;
    }
    
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) unf[a] = b;
    }
    
    public int find(int v) {
        if(unf[v] == v) return v;
        else return unf[v] = find(unf[v]);
    }
    
    public int solution(int n, int[][] computers) {
        int connection = 0;
        unf = new int[n];
        for(int i = 0; i < n; i++) unf[i] = i;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j && computers[i][j] == 1) {
                    if(!isSameNetwork(i, j)) {
                        connection++;
                        union(i, j);
                    }
                }
            }
        }
        return n - connection;
    }
}