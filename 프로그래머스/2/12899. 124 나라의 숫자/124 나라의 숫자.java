
class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String[] numbers = {"4", "1", "2"};
        while(n > 0) {
            int remain = n % 3;
            n /= 3;
            if(remain == 0) n--;
            sb.append(numbers[remain]);
        }
        return sb.reverse().toString();
    }
}