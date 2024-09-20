class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while(!isFit(wallet, bill)) {
            if(bill[0] > bill[1]) bill[0] = bill[0] / 2;
            else bill[1] = bill[1] / 2;
            answer++;
            // System.out.printf("%d, %d, %d\n", bill[0], bill[1], answer);
        }
        return answer;
    }
    
    public boolean isFit(int[] wallet, int[] bill) {
        if(wallet[0] >= bill[0] && wallet[1] >= bill[1]) return true;
        if(wallet[1] >= bill[0] && wallet[0] >= bill[1]) return true;
        return false;
    }
}