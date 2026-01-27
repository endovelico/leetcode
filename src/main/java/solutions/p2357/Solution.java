package solutions.p2357;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> uniqueNonZero = new HashSet<>();

        // Add all non-zero numbers to the set
        for (int num : nums) {
            if (num != 0) {
                uniqueNonZero.add(num);
            }
        }

        // The minimum operations = number of unique non-zero numbers
        return uniqueNonZero.size();
    }
}
