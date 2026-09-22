package solutions.p1346;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean checkIfExist(int[] arr) {

        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {

            // Check if num / 2 already exists
            if (num % 2 == 0 && seen.contains(num / 2)) {
                return true;
            }

            // Check if 2 * num already exists
            if (seen.contains(num * 2)) {
                return true;
            }

            seen.add(num);
        }

        return false;
    }
}