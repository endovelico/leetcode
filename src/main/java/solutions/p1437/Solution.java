package solutions.p1437;

class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int zeros = k; // assume the first 1 is okay
        for (int num : nums) {
            if (num == 1) {
                if (zeros < k) return false;
                zeros = 0;
            } else {
                zeros++;
            }
        }
        return true;
    }
}
