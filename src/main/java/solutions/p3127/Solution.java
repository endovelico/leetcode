package solutions.p3127;

class Solution {
    public boolean canMakeSquare(char[][] grid) {

        // iterate over all 2x2 subgrids
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {

                int black = 0;

                // count 'B' in this 2x2 block
                if (grid[i][j] == 'B') black++;
                if (grid[i][j + 1] == 'B') black++;
                if (grid[i + 1][j] == 'B') black++;
                if (grid[i + 1][j + 1] == 'B') black++;

                int white = 4 - black;

                // check if we can make all same with ≤ 1 change
                if (black >= 3 || white >= 3) {
                    return true;
                }
            }
        }

        return false;
    }
}