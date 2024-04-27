class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int s_idx = 0;
        int p = 1;
        while(p<=n) {
            // 전파 내에 있는경우
            if(s_idx < stations.length && p >= stations[s_idx]-w) {
                p = stations[s_idx]+w+1; // 현재 위치를 바로 해당 기지국 전파 오른쪽 벗어나게 변경
                s_idx++;
            } else { // 전파범위 밖인경우
                answer++;
                p += (w*2)+1;
            }
        }
        return answer;
    }
}