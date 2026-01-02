package solutions.p1470;

public class Solution {

    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            result[idx++] = nums[i];     // x_i
            result[idx++] = nums[i + n]; // y_i
        }

        return result;
    }

}
