class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n >= 3) {
            int q = n / 3; // 몫
            int m = n % 3; // 나머지
            n = n / 3;
            sb.append(m);
        }
        sb.append(n);
        return Integer.parseInt(sb.toString(), 3);
    }
}