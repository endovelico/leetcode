package solutions.p214;

class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return s;

        String reversed = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + reversed;

        int[] lps = new int[combined.length()];

        int current_match_length = 0;
        int current_index = 1;

        while (current_index < combined.length()) {
            if (combined.charAt(current_index) == combined.charAt(current_match_length)) {
                current_match_length++;
                lps[current_index] = current_match_length;
                current_index++;
            } else {
                if (current_match_length > 0) {
                    current_match_length = lps[current_match_length - 1];
                } else {
                    lps[current_index] = 0;
                    current_index++;
                }
            }
        }

        int longest_palindromic_prefix_length = lps[combined.length() - 1];

        String suffix_to_add =
                s.substring(longest_palindromic_prefix_length);

        return new StringBuilder(suffix_to_add)
                .reverse()
                .append(s)
                .toString();
    }
}
