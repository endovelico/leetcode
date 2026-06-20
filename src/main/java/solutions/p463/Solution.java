package solutions.p463;

class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int perimeter = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int neighbors = 0;

                    if (i > 0 && grid[i - 1][j] == 1) neighbors++;
                    if (i < m - 1 && grid[i + 1][j] == 1) neighbors++;
                    if (j > 0 && grid[i][j - 1] == 1) neighbors++;
                    if (j < n - 1 && grid[i][j + 1] == 1) neighbors++;

                    perimeter += 4 - neighbors;
                }
            }
        }

        return perimeter;
    }
}