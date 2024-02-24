package solutions.p58;

public class Solution {

    public int lengthOfLastWord(String s) {

        int letter_count = 0;
        int whitespace_count=0;

        for (int index = s.length() - 1; index + 1> 0; index--) {

            if(s.charAt(index) != ' ') letter_count++; // Found a non-whitespace!
            if(s.charAt(index) == ' ' && letter_count > 0) return letter_count; // Found a whitespace after having found a letter!
        }

        // This helps with the edge case of having a trailing whitespace only word, eg:
        // "abc "
        return letter_count;
    }
}