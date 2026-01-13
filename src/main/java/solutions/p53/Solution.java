package solutions.p53;

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];       // at least one element
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // either extend the streak or start new at nums[i]
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
