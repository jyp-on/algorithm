// 가장 많이 반복되는 문자열의 길이
class Solution {
    public int solution(String s) {
        int answer = s.length();
        int count = 1;
        for(int i=1; i<=s.length()/2; i++) { // 압축길이
            StringBuilder result = new StringBuilder();
            String base = s.substring(0, i);
            for(int j=i; j<=s.length(); j+=i) {
                int endIdx = Math.min(j + i, s.length());
                String compare = s.substring(j, endIdx);
                if(base.equals(compare)) {
                    count++;
                } else {
                    if(count >= 2) {
                        result.append(count);
                    }
                    result.append(base);
                    base = compare; // 기준 문자열 변경
                    count = 1;
                }
            }
            result.append(base); // 마지막 문자 붙이기
            answer = Math.min(answer, result.length());
        }
        return answer;
    }
}