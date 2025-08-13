class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0) return false;
        while(n % 3 == 0) {
            n /= 3;
            // System.out.println(n);
        } 
        return n == 1;
    }
}