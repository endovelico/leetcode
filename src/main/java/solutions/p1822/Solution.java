package solutions.p1822;

class Solution {
    public int arraySign(int[] nums) {
        int sign = 1;

        for (int num : nums) {
            if (num == 0) return 0;      // any zero → product is zero
            if (num < 0) sign *= -1;     // flip sign for negative numbers
        }

        return sign; // 1 if positive, -1 if negative
    }
}