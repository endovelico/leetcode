package solutions.p213;

class Solution {

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        return Math.max(
                robRange(nums, 0, nums.length - 2),
                robRange(nums, 1, nums.length - 1)
        );
    }

    private int robRange(int[] nums, int start, int end) {
        Integer[] memo = new Integer[nums.length];
        return robFrom(start, end, nums, memo);
    }

    private int robFrom(int i, int end, int[] nums, Integer[] memo) {
        if (i > end) return 0;
        if (memo[i] != null) return memo[i];

        int skip = robFrom(i + 1, end, nums, memo);
        int take = nums[i] + robFrom(i + 2, end, nums, memo);

        memo[i] = Math.max(skip, take);
        return memo[i];
    }
}
