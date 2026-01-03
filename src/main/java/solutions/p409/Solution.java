package solutions.p409;

class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128]; // covers all ASCII letters

        // Count frequencies
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        int length = 0;
        boolean has_odd = false;

        for (int count : freq) {
            if (count % 2 == 0) {
                length += count;
            } else {
                length += count - 1; // use the even part
                has_odd = true;
            }
        }

        // One odd character can sit in the middle
        if (has_odd) {
            length += 1;
        }

        return length;
    }
}

