class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i = 0; i <= n; i++) {
            ans[i] = countOne(parseBinary(i));
        }

        return ans;
    }

    public String parseBinary(int i) {
        StringBuilder sb = new StringBuilder();
        while(i > 0) {
            sb.append(i % 2);
            i = i / 2;
        }
        sb.append(i);
        return sb.reverse().toString();
    }

    public int countOne(String s) {
        int cnt = 0;
        for (char x : s.toCharArray()) {
            if (x == '1') cnt++;
        }
        return cnt;
    }
}