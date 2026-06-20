package solutions.p3417;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> zigzagTraversal(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        boolean toSkip = false;

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            if (i % 2 == 0) {
                // left → right
                for (int j = 0; j < n; j++) {

                    if(!toSkip) result.add(grid[i][j]);
                    toSkip = !toSkip;
                }
            } else {
                // right → left
                for (int j = n - 1; j >= 0; j--) {
                    if(!toSkip) result.add(grid[i][j]);
                    toSkip = !toSkip;
                }
            }
        }

        return result;
    }
}