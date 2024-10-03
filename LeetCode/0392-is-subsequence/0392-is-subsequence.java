class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        int cnt = 0;
        int j = 0;
        for(int i=0; i<a.length; i++) {
            for(; j<b.length; j++) {
                if(a[i] == b[j]) {
                    cnt++;
                    j++;
                    break;
                }
            }
        }
        // System.out.println(cnt);
        return cnt == a.length ? true : false;
    }
}