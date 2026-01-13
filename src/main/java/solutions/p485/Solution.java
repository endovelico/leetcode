package solutions.p485;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max_count = 0;
        int current_count = 0;

        for (int n : nums) {
            if (n == 1) {
                current_count++;
                max_count = Math.max(max_count, current_count);
            } else {
                current_count = 0;
            }
        }

        return max_count;
    }
}
