import java.util.*;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        int[] freq1 = new int[26]; // word1의 알파벳 빈도수
        int[] freq2 = new int[26]; // word2의 알파벳 빈도수

        Set<Character> set1 = new HashSet<>(); // word1의 문자 집합
        Set<Character> set2 = new HashSet<>(); // word2의 문자 집합

        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
            set1.add(c);
        }

        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
            set2.add(c);
        }

        // 문자 집합이 다르면 false
        if (!set1.equals(set2)) return false;

        // 빈도수 배열을 정렬하여 비교
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }
}
