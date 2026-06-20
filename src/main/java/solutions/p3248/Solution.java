package solutions.p3248;

import java.util.List;

class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int row = 0;
        int col = 0;

        for (String cmd : commands) {
            if (cmd.equals("UP")) {
                if (row > 0) row--;
            }
            else if (cmd.equals("DOWN")) {
                if (row < n - 1) row++;
            }
            else if (cmd.equals("LEFT")) {
                if (col > 0) col--;
            }
            else if (cmd.equals("RIGHT")) {
                if (col < n - 1) col++;
            }
        }

        // return final encoded position (row-major index)
        return row * n + col;
    }
}