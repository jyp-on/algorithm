import java.util.Arrays;
 
public class Solution {
 
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int idx = 0;
        
        for (int i = 0; i < numbers.length; i++) {
            long t = numbers[i];
            while(true) {
                if(getCnt(++t ^ numbers[i]) < 2) {
                    answer[idx++] = t;
                    break;
                }
            }
            
        }
        return answer;
    }
    
    // 1의 개수
    private static int getCnt(long n) {
        int cnt = 0;
        while(n>1) {
            if(n%2==1) cnt++;
            n = n/2;
        }
        return cnt;
    }
}