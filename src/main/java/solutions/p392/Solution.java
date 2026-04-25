package solutions.p392;

class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0; // pointer for s
        int j = 0; // pointer for t

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; // move to next char in s
            }
            j++; // always move in t
        }

        // If we've matched all characters in s, it's a subsequence
        return i == s.length();
    }
}