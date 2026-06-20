package solutions.p2946;

class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        k = k % n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int originalIndex = (j + k) % n;

                // after shifting row i by k, value must match original row structure
                if (mat[i][originalIndex] != mat[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}