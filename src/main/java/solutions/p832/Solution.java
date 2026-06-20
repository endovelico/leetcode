package solutions.p832;

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {

        int n = image.length;

        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;

            while (l <= r) {

                // swap + invert in one step
                int left = image[i][l] ^ 1;
                int right = image[i][r] ^ 1;

                image[i][l] = right;
                image[i][r] = left;

                l++;
                r--;
            }
        }

        return image;
    }
}