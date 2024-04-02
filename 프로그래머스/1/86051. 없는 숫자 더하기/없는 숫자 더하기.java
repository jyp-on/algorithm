class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int n = numbers.length;
        boolean[] isExist = new boolean[10];
        for(int x : numbers) isExist[x] = true;
        for(int i = 1; i <= 9; i++) {
            if(!isExist[i]) answer += i;
        }
        return answer;
    }
}