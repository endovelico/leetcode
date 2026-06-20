package solutions.p566;

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int m = mat.length;
        int n = mat[0].length;

        // If reshape is not possible then stop
        if(r * c != m * n) return mat;

        //build the target
        int[][] result = new int[r][c];

        // we start at these indexes
        int row = 0;
        int col = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                result[row][col] = mat[i][j];

                col++;
                if(col == c) {
                    col = 0;
                    row++;
                }
            }
        }

        return result;
    }
}