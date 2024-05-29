class Solution {
    public int solution(int storey) {
        int answer = 0;
        while(storey > 0) {
            int last = storey % 10;
            storey = storey / 10;
            
            if(last == 5) {
                if(storey % 10 >= 5) { // 다음자리 
                    answer += (10 - last);
                    storey++;
                } else {
                    answer += last;
                }
            } else if(last > 5) {
                answer += (10 - last); // 윗자릿수로 가기위해 필요한 수만큼 answer 추가
                storey++; // 자릿수 하나 올림
            } else {
                answer += last; // 아랫자릿수로 이미 왔으니 answer만 추가
            }
        }
        return answer;
    }
}