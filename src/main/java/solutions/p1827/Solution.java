package solutions.p1827;

class Solution {

    public int minOperations(int[] nums) {
        if (nums.length <= 1) return 0;

        int minOperations = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) continue;

            int increment = nums[i - 1] - nums[i] + 1;
            nums[i] += increment;          // increment the current element
            minOperations += increment;    // add to total operations
        }

        return minOperations;
    }
}
