package solutions.p1304;

class Solution {
    public int[] sumZero(int n) {

        int[] result = new int[n];
        int index = 0;

        // If n is odd, use 0
        if (n % 2 == 1) {
            result[index++] = 0;
        }

        // Add pairs: -1, 1, -2, 2, ...
        for (int i = 1; index < n; i++) {
            result[index++] = i;
            result[index++] = -i;
        }

        return result;
    }
}