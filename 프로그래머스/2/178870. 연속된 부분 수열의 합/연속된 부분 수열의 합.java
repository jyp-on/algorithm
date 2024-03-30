class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[2];
        int N = arr.length;
        int max_len = Integer.MAX_VALUE;
        int sum = 0;
        for(int L = 0, R = 0; L < N; L++) {
            while(R < N && sum < k) { // sum이 k같거나 크면 break;
                sum += arr[R++];
            }
            if(sum == k) { 
                int range = R - L + 1;
                if(max_len > range) { // 기존에 구했던 길이보다 작다면 답
                    answer[0] = L;
                    answer[1] = R-1;
                    max_len = range;
                }
            }
            sum -= arr[L];
        }
        return answer;
    }
}