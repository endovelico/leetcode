package solutions.p1005;

import java.util.Arrays;

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        // Step 1: Flip negatives greedily
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            } else {
                break;
            }
        }

        // Step 2: Handle leftover flips
        if (k % 2 == 1) {
            Arrays.sort(nums);  // find smallest number
            nums[0] = -nums[0];
        }

        // Step 3: Sum array
        int sum = 0;
        for (int num : nums) sum += num;

        return sum;
    }
}
