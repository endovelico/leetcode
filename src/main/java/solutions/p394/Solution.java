package solutions.p394;

import java.util.Stack;

class Solution {
    private int index = 0;

    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();

        while (index < s.length() && s.charAt(index) != ']') {
            char c = s.charAt(index);

            // Case 1: digit → parse full number
            if (Character.isDigit(c)) {
                int k = 0;
                while (Character.isDigit(s.charAt(index))) {
                    k = k * 10 + (s.charAt(index++) - '0');
                }

                index++; // skip '['
                String decoded = decodeString(s);
                index++; // skip ']'

                result.append(decoded.repeat(k));
            }
            // Case 2: letter → append
            else {
                result.append(c);
                index++;
            }
        }

        return result.toString();
    }
}
