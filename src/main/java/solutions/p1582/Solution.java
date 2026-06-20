package solutions.p1582;

class Solution {

    public int numSpecial(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        // Step 1: count 1s in rows and columns
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        // Step 2: check special cells
        int special_count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 &&
                        rowCount[i] == 1 &&
                        colCount[j] == 1) {
                    special_count++;
                }
            }
        }

        return special_count;
    }
}