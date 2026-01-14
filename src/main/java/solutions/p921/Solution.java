package solutions.p921;

class Solution {
    public int minAddToMakeValid(String s) {
        int open_count = 0; // number of unmatched '('
        int add_needed = 0; // number of '(' we need to add for unmatched ')'

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open_count++; // found '(', might need a ')' later
            } else { // ch == ')'
                if (open_count > 0) {
                    open_count--; // match it with an existing '('
                } else {
                    add_needed++; // no '(' to match, need to add one
                }
            }
        }

        // add ')' for any unmatched '('
        return add_needed + open_count;
    }
}
