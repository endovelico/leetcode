package solutions.p3226;

class Solution {
    public int minChanges(int n, int k) {

        int count = 0;

        while (n > 0 || k > 0) {

            int nBit = n & 1;
            int kBit = k & 1;

            // 0 -> 1 is impossible
            if (nBit == 0 && kBit == 1) {
                return -1;
            }

            // 1 -> 0 requires one change
            if (nBit == 1 && kBit == 0) {
                count++;
            }

            n >>= 1;
            k >>= 1;
        }

        return count;
    }
}