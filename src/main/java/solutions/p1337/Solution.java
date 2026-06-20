package solutions.p1337;

import java.util.Arrays;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] strength = new int[m][2];

        // Step 1: compute strength
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            strength[i][0] = i;      // row index
            strength[i][1] = count;  // strength
        }

        // Step 2: sort by strength, then index
        Arrays.sort(strength, (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });

        // Step 3: take first k
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = strength[i][0];
        }

        return result;
    }
}