package solutions.p349;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import java.util.List;

class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        // 1️⃣ Add first array to set
        for (int n : nums1) {
            seen.add(n);
        }

        // 2️⃣ Check second array
        for (int n : nums2) {
            if (seen.contains(n)) {
                result.add(n);
                seen.remove(n); // prevent duplicates
            }
        }

        // Convert list to array
        return result.stream().mapToInt(i -> i).toArray();
    }

}