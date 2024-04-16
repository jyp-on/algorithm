class Solution {
    static int answer = 0;
    static int t;
    static int[] arr;
    public void DFS(int L, int sum) {
        if(L==arr.length) {
            if(sum==t) answer++;
        } else {
            DFS(L+1, sum+arr[L]);
            DFS(L+1, sum-arr[L]);
        }
    }
    public int solution(int[] numbers, int target) {
        t = target;
        arr = numbers;
        DFS(0, 0);
        return answer;
    }
}