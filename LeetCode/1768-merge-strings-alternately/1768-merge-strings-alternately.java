class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        StringBuilder answer = new StringBuilder();

        if(len1 > len2) {
            for(int i=0; i<len2; i++) {
                answer.append(word1.charAt(i));
                answer.append(word2.charAt(i));
            }
            answer.append(word1.substring(len2));
        } else {
            for(int i=0; i<len1; i++) {
                answer.append(word1.charAt(i));
                answer.append(word2.charAt(i));
            }
            answer.append(word2.substring(len1));
        }

        return answer.toString();
    }
}