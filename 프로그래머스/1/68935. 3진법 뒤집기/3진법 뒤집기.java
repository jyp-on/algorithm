class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n >= 3) {
            int q = n / 3; // 몫
            int m = n % 3; // 나머지
            n = n / 3;
            sb.append(m);
        }
        sb.append(n);
        int i = 0;
        for(char x : sb.reverse().toString().toCharArray()) {
            if(x == '0') {
                i++; continue;
            }
            answer += Math.pow(3, i++) * (x-'0');
        }
        return answer;
    }
}