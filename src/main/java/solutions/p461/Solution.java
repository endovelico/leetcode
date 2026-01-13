package solutions.p461;

class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;

        while (xor != 0) {
            xor = xor & (xor - 1); // remove lowest 1-bit
            count++;
        }

        return count;
    }
}