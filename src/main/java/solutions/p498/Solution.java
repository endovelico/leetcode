package solutions.p498;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[0];
        }

        int m = mat.length;
        int n = mat[0].length;

        int[] result = new int[m * n];
        int index = 0;

        // We track all diagonals by sum = row + col
        for (int d = 0; d < m + n - 1; d++) {

            // temporary storage for current diagonal
            List<Integer> temp = new ArrayList<>();

            int r = (d < n) ? 0 : d - n + 1;
            int c = (d < n) ? d : n - 1;

            while (r < m && c >= 0) {
                temp.add(mat[r][c]);
                r++;
                c--;
            }

            // even diagonal → reverse order
            if (d % 2 == 0) {
                Collections.reverse(temp);
            }

            // add to result
            for (int val : temp) {
                result[index++] = val;
            }
        }

        return result;
    }
}