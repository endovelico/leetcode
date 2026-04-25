package solutions.p408;

public class Solution {

    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0; // pointer for word
        int j = 0; // pointer for abbr

        while (i < word.length() && j < abbr.length()) {
            char c = abbr.charAt(j);

            // Case 1: if c is a digit
            if (Character.isDigit(c)) {
                if (c == '0') return false; // leading zero not allowed
                int num = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i += num; // move i forward by num positions
            } else {
                // Case 2: c is a letter
                if (i >= word.length() || word.charAt(i) != c) return false;
                i++;
                j++;
            }
        }

        // Both pointers should reach the end
        return i == word.length() && j == abbr.length();
    }
}
