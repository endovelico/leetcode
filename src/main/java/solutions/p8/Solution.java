package solutions.p8;

class Solution {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;

        int index = 0;
        int n = s.length();
        int sign = 1;
        long result = 0; // Use long to handle overflow temporarily

        // 1. Skip leading whitespaces
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // 2. Handle sign
        if (index < n) {
            if (s.charAt(index) == '+') {
                sign = 1;
                index++;
            } else if (s.charAt(index) == '-') {
                sign = -1;
                index++;
            }
        }

        // 3. Convert digits to number
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            result = result * 10 + digit;

            // 4. Check for overflow
            if (sign * result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            index++;
        }

        return (int)(sign * result);
    }
}
