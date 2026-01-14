package solutions.p1009;

class Solution {

    public int bitwiseComplement(int n) {
        if (n == 0) return 1;

        // Determine how many bits n has
        int k = Integer.toBinaryString(n).length();

        // Build a mask with k ones
        int mask = (1 << k) - 1;

        // Flip only those k bits
        return n ^ mask;
    }


}
