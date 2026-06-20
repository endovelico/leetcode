package solutions.p3033;

class Solution {
    public int[][] modifiedMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // Step 1: compute replacement value per column
        int[] colValue = new int[n];

        for (int j = 0; j < n; j++) {
            int best = Integer.MIN_VALUE;

            for (int i = 0; i < m; i++) {
                if (mat[i][j] != -1) {
                    best = Math.max(best, mat[i][j]);
                }
            }

            colValue[j] = best;
        }

        // Step 2: build result using column dependency
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == -1) {
                    result[i][j] = colValue[j];
                } else {
                    result[i][j] = mat[i][j];
                }
            }
        }

        return result;
    }
}