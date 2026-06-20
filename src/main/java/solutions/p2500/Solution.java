package solutions.p2500;

import java.util.Arrays;

class Solution {
    public int deleteGreatestValue(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Step 1: sort each row
        for (int i = 0; i < m; i++) {
            Arrays.sort(grid[i]);
        }

        int result = 0;

        // Step 2: process from largest column to smallest
        for (int col = n - 1; col >= 0; col--) {

            int maxInCol = 0;

            for (int row = 0; row < m; row++) {
                maxInCol = Math.max(maxInCol, grid[row][col]);
            }

            result += maxInCol;
        }

        return result;
    }
}