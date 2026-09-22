package solutions.p1863;

class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int index, int xor) {

        // We've decided whether to include every number
        if (index == nums.length) {
            return xor;
        }

        // Option 1: don't include nums[index]
        int without = dfs(nums, index + 1, xor);

        // Option 2: include nums[index]
        int with = dfs(nums, index + 1, xor ^ nums[index]);

        return without + with;
    }
}