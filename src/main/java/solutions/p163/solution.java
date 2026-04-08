package solutions.p163;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();

        long prev = (long) lower - 1;

        for (int i = 0; i <= nums.length; i++) {
            long curr = (i < nums.length) ? nums[i] : (long) upper + 1;

            if (curr - prev >= 2) {
                result.add(Arrays.asList((int)(prev + 1), (int)(curr - 1)));
            }

            prev = curr;
        }

        return result;
    }
}