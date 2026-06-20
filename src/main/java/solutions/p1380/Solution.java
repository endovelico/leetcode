package solutions.p1380;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] rowMin = new int[m];
        int[] colMax = new int[n];

        // Step 1: compute row minimums
        for (int i = 0; i < m; i++) {
            int minVal = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                minVal = Math.min(minVal, matrix[i][j]);
            }
            rowMin[i] = minVal;
        }

        // Step 2: compute column maximums
        for (int j = 0; j < n; j++) {
            int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                maxVal = Math.max(maxVal, matrix[i][j]);
            }
            colMax[j] = maxVal;
        }

        // Step 3: find lucky numbers
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                if (val == rowMin[i] && val == colMax[j]) {
                    result.add(val);
                }
            }
        }

        return result;
    }
}