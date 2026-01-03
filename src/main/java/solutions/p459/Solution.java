package solutions.p459;

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        // Try every possible block size
        for (int len = 1; len <= n / 2; len++) {

            // Block size must divide total length
            if (n % len != 0) continue;

            String block = s.substring(0, len);
            StringBuilder repeated = new StringBuilder();

            // Repeat the block n / len times
            for (int i = 0; i < n / len; i++) {
                repeated.append(block);
            }

            // Check full reconstruction
            if (repeated.toString().equals(s)) {
                return true;
            }
        }

        return false;
    }
}
