package solutions.p1403;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);

        int total = 0;
        for (int n : nums) total += n;

        int current = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            current += nums[i];
            result.add(nums[i]);

            if (current > total - current) {
                break;
            }
        }

        return result;
    }
}
