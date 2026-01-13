package solutions.p448;

import java.util.*;

class SolutionSorted {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missing = new ArrayList<>();
        Arrays.sort(nums);  // sort the array first

        int n = nums.length;
        int expected = 1;   // numbers we expect from 1 to n
        int i = 0;

        while (expected <= n) {
            // Skip duplicates in the sorted array
            while (i < n && nums[i] < expected) {
                i++;
            }

            // If expected number is missing
            if (i >= n || nums[i] > expected) {
                missing.add(expected);
            } else {
                // nums[i] == expected → number exists
                i++;
            }

            expected++;
        }

        return missing;
    }
}
