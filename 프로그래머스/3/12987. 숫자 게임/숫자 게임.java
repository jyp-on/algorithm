import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int a=0, b=0; b<B.length;) {
            if(A[a] < B[b]) {
                a++; b++;
                answer++;
            } else if(A[a] > B[b]) {
                b++;
            } else { // 같은 경우
                b++;     
            }
        }
        return answer;
    }
}