package solutions.p599;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {

        HashMap<String, Integer> map = new HashMap<>();

        // Store restaurants from list1 and their indexes
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int minSum = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();

        // Iterate through list2
        for (int i = 0; i < list2.length; i++) {

            // Only consider restaurants that appear in BOTH lists
            if (map.containsKey(list2[i])) {

                int sum = map.get(list2[i]) + i;

                if (sum < minSum) {
                    // Found a new minimum
                    minSum = sum;

                    // Remove restaurants with larger sums
                    result.clear();

                    result.add(list2[i]);

                } else if (sum == minSum) {
                    // Another restaurant has the same minimum
                    result.add(list2[i]);
                }
            }
        }

        return result.toArray(new String[0]);
    }
}