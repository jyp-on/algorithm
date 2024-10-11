import java.math.*;
class Solution {
    char[] vowel = new char[]{'a', 'e', 'i', 'o', 'u'};
    public int maxVowels(String s, int k) {
        char[] c = s.toCharArray();
        int answer = 0;
        int vowelCnt = 0;
        for(int i = 0; i < k; i++) {
            if(isVowel(c[i])) vowelCnt++;
        }

        answer = vowelCnt;
        int lt = 0, rt = k;
        while(rt < c.length) {
            if(isVowel(c[lt++])) vowelCnt--;
            if(isVowel(c[rt++])) vowelCnt++;
            answer = Math.max(answer, vowelCnt);
        }

        return answer;
    }

    public boolean isVowel(char input) {
        for (char v : vowel) {
            if (input == v) return true;
        }
        return false;
    } 
}