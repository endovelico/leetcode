package solutions.p59;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int num = 1;
        int target = n * n;

        while (num <= target) {

            // 👉 left → right
            for (int j = left; j <= right && num <= target; j++) {
                result[top][j] = num++;
            }
            top++;

            // 👉 top → bottom
            for (int i = top; i <= bottom && num <= target; i++) {
                result[i][right] = num++;
            }
            right--;

            // 👉 right → left
            for (int j = right; j >= left && num <= target; j--) {
                result[bottom][j] = num++;
            }
            bottom--;

            // 👉 bottom → top
            for (int i = bottom; i >= top && num <= target; i--) {
                result[i][left] = num++;
            }
            left++;
        }

        return result;
    }
}