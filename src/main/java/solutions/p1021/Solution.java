package solutions.p1021;

import java.util.Stack;

class Solution {
    public String removeOuterParentheses(String s) {
        if(s.isEmpty()) return s;

        int parenthesis_depth = 0;
        StringBuilder builder = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (parenthesis_depth > 0) builder.append(c);
                parenthesis_depth++;
            } else { // ')'
                parenthesis_depth--;
                if (parenthesis_depth > 0) builder.append(c);
            }
        }

        return builder.toString();
    }
}
