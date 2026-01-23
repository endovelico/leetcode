package solutions.p1196;


import java.util.Arrays;

class Solution {
    public int maxNumberOfApples(int[] piles) {
        // Sort piles so we can take smaller piles first
        Arrays.sort(piles);

        int totalApples = 0;  // running total of apples in the basket
        int pileCount = 0;    // number of piles added

        // Iterate over each pile
        for (int pile : piles) {
            if (totalApples + pile <= 5000) {
                totalApples += pile;
                pileCount++;
            } else {
                // Adding this pile would exceed the basket limit
                break;
            }
        }

        return pileCount;
    }
}