package solutions.p1512;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;

        for (int n : nums) {
            int seen = freq.getOrDefault(n, 0);
            count += seen;      // each previous occurrence makes a new pair
            freq.put(n, seen + 1);
        }

        return count;
    }
}
