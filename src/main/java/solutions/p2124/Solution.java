package solutions.p2124;

class Solution {
    public boolean checkString(String s) {
        boolean seenB = false;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                seenB = true;
            } else if (seenB) {
                return false; // found 'a' after a 'b'
            }
        }

        return true;
    }
}