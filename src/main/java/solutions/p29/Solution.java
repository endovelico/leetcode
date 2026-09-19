package solutions.p29;

class Solution {

    public int divide(int dividend, int divisor) {

        // Overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean negative = (dividend < 0) != (divisor < 0);

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long quotient = 0;

        while (a >= b) {

            long value = b;
            long count = 1;

            // Find the largest doubled divisor that fits
            while (a >= value + value) {
                value += value;
                count += count;
            }

            // Subtract that large chunk
            a -= value;
            quotient += count;
        }

        return (int) (negative ? -quotient : quotient);
    }
}