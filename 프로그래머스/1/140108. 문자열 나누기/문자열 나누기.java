class Solution {
    public int solution(String s) {
        int answer = 1;
        int x_cnt = 1;
        int t_cnt = 0;
        char x = s.charAt(0);
        for(int i = 1; i < s.length(); i++) {
            System.out.println(i + " " +x_cnt + " " +t_cnt + " " + answer);
            if(x_cnt == 0) {
                x = s.charAt(i);
                x_cnt = 1;
            } else {
                if(s.charAt(i) == x) x_cnt++;
                else t_cnt++;
                
                if(x_cnt == t_cnt) {
                    x_cnt = 0;
                    t_cnt = 0;
                    if(i != s.length()-1) answer++;
                }
            }
            
        }
        return answer;
    }
}