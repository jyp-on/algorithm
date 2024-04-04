class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0,0};
        int zero = 0, same=0;
        for(int i=0; i<lottos.length; i++){
            if(lottos[i] == 0){
                zero++;
                continue;    
            }
            for(int j=0;j<win_nums.length; j++){
                if(lottos[i] == win_nums[j])
                    same++;
            }
        }
        answer[0] = 7-(zero+same);
        answer[1] = 7-same;
        if(zero + same < 2)
            answer[0] = answer[1] = 6;
        if(answer[1] == 7)
            answer[1]--;
        return answer;
    }
}