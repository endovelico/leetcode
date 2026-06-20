package solutions.p1260;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int size = m * n;

        k = k % size;

        List<List<Integer>> result = new ArrayList<>();

        // initialize result grid
        for (int i = 0; i < m; i++) {
            result.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                result.get(i).add(0);
            }
        }

        for (int i = 0; i < size; i++) {
            int newIndex = (i + k) % size;

            int oldRow = i / n;
            int oldCol = i % n;

            int newRow = newIndex / n;
            int newCol = newIndex % n;

            result.get(newRow).set(newCol, grid[oldRow][oldCol]);
        }

        return result;
    }
}