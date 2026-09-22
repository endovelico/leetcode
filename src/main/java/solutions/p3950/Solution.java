package solutions.p3950;

class Solution {
    public boolean consecutiveSetBits(int n) {

        int count = 0;
        int previousBit = 0;

        while (n > 0) {

            int currentBit = n & 1;

            if (currentBit == 1 && previousBit == 1) {
                count++;
            }

            previousBit = currentBit;
            n >>= 1;
        }

        return count == 1;
    }
}