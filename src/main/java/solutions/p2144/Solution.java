package solutions.p2144;

import java.util.Arrays;

class Solution {

    public int minimumCost(int[] cost) {

        // Sort in descending order so expensive candies come first
        Arrays.sort(cost);
        int n = cost.length;
        int totalCost = 0;

        // Iterate from the most expensive candy to the cheapest
        for (int i = n - 1; i >= 0; i -= 3) {
            // Pay for the first candy
            totalCost += cost[i];

            // Pay for the second candy if it exists
            if (i - 1 >= 0) {
                totalCost += cost[i - 1];
            }

            // Skip the third candy (free)
            // i - 2 is automatically skipped
        }

        return totalCost;
    }
}
