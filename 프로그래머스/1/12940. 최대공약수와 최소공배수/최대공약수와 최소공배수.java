class Solution {
    public int[] solution(int n, int m) {
        return new int[]{GCD(n,m), n * m / GCD(n,m)};
    }
    public int GCD(int a, int b) {
        if(b == 0) return a;
        else return GCD(b, a%b);
    }
}