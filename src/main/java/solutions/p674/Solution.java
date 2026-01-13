package solutions.p674;


class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;

        int maxCount = 1;       // At least one number is always a subsequence
        int currentCount = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentCount++;                    // extend current streak
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 1;                  // reset streak
            }
        }

        return maxCount;
    }
}
