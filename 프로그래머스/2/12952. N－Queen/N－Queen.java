class Solution {
    int[] arr;
    int N, answer;
    public int solution(int n) {
        N = n;
        answer = 0;
        arr = new int[n+1]; // 0 제외
        n_queen(1);
        return answer;
    }
    
    void n_queen(int col) {
        if(col == N+1) {
            answer++;
            return;
        }
        
        for(int i=1; i<=N; i++) {
            arr[col] = i;
            if(check(col)) {
                n_queen(col+1);
            }
        }
    }
    
    boolean check(int col) {
        for(int i=1; i<col; i++) {
            if(arr[i] == arr[col]) { // 행 겹치는 경우
                return false;
            }
            if(Math.abs(i-col) == Math.abs(arr[i]-arr[col])) { // 대각선 겹치는 경우
                return false;
            }
        }
        
        return true;
    }
}