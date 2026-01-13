package solutions.p190;

class Solution {

    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;          // make space for next bit
            result |= (n & 1);     // append last bit
            n >>>= 1;              // unsigned right shift
        }

        return result;
    }
}
