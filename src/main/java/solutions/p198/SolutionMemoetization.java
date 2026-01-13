package solutions.p198;


class SolutionMemoetization {

    public int rob(int[] nums) {
        Integer[] memo = new Integer[nums.length];
        return robFrom(0, nums, memo);
    }

    private int robFrom(int i, int[] nums, Integer[] memo) {
        // base case: past the last house
        if (i >= nums.length) return 0;

        // memoized result
        if (memo[i] != null) return memo[i];

        // decision
        int skip = robFrom(i + 1, nums, memo);
        int take = nums[i] + robFrom(i + 2, nums, memo);

        memo[i] = Math.max(skip, take);
        return memo[i];
    }
}
