class Solution {
    public String reverseWords(String s) {
        // Trim the input string to remove leading and trailing spaces
        String[] str = s.trim().split("\\s+");

        // Initialize the output string
        StringBuilder sb = new StringBuilder();

        // Iterate through the words in reverse order
        for (int i = str.length - 1; i > 0; i--) {
            // Append the current word and a space to the output
            sb.append(str[i] + " ");
        }

        // Append the first word to the output (without trailing space)
        return sb.append(str[0]).toString();
    }
}