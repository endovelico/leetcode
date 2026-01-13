package solutions.p342;

class Solution {

    public boolean isPowerOfFour(int n) { //O(log₄ n)

        while (n > 1) {
            if (n % 4 != 0) return false;
            n /= 4;
        }
        return n == 1;
    }

    public boolean isPowerOfFourv2(int n) { //O(1)

        return n > 0
                && (n & (n - 1)) == 0
                && (n & 0x55555555) != 0;
    }

}