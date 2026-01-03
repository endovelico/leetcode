package solutions.p1392;

public class Solution {

    public String longestPrefix(String s) {
        int string_length = s.length(); //ababab

        int[] longest_prefix_suffix = new int[string_length];

        int current_match_length = 0;
        int current_index = 1;

        while (current_index < string_length) {

            if (s.charAt(current_index) == s.charAt(current_match_length)) {
                current_match_length++;
                longest_prefix_suffix[current_index] = current_match_length;
                current_index++;

            } else {
                if (current_match_length > 0) {
                    current_match_length =
                            longest_prefix_suffix[current_match_length - 1];
                } else {
                    longest_prefix_suffix[current_index] = 0;
                    current_index++;
                }
            }
        }

        int happy_prefix_length =
                longest_prefix_suffix[string_length - 1];

        return s.substring(0, happy_prefix_length);
    }

}
