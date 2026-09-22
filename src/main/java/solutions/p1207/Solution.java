package solutions.p1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> frequency = new HashMap<>();

        // Count how many times each number appears
        for (int num : arr) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        Set<Integer> occurrences = new HashSet<>();

        // Check that every frequency is unique
        for (int count : frequency.values()) {
            if (!occurrences.add(count)) {
                return false;
            }
        }

        return true;
    }
}