package solutions.p2595;

class Solution {
    public int[] evenOddBit(int n) {

        int even = 0;
        int odd = 0;
        int index = 0;

        while (n > 0) {

            // Check the rightmost bit
            if ((n & 1) == 1) {

                if (index % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }

            // Move to the next bit
            n >>= 1;
            index++;
        }

        return new int[]{even, odd};
    }
}
