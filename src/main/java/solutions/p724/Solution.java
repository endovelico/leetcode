package solutions.p724;

class Solution {
    public int pivotIndex(int[] nums) {

        int total_sum = 0;
        for (int number : nums) total_sum += number;

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == total_sum - leftSum - nums[i]) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}

