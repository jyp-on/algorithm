class Solution {
    static boolean[] ch;
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int k=j+1; k<n; k++) {
                    if(check(nums[i]+nums[j]+nums[k])) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
    
    
    public static boolean check(int n) {
        if(n<2) return false;
        for(int i=2; i <= Math.sqrt(n); i++) {
            if(n%i==0) return false;
        }
        return true;
    }
}