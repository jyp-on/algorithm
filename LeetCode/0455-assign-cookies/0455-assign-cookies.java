class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j=0;
        int ans=0;
        for(int i=0; i<g.length; i++) {
            for(; j<s.length; j++) {
                if(g[i]<=s[j]) {
                    ans++;
                    j++;
                    break;
                }
            }
        }
        return ans;
    }
}