package solutions.p977;

class Solution {
    public int[] sortedSquares(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        int left = 0;
        int right = n - 1;
        int write = n - 1;   // fill result from the end

        while (left <= right) {

            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];

            if (leftSq > rightSq) {
                result[write] = leftSq;
                left++;
            } else {
                result[write] = rightSq;
                right--;
            }

            write--;
        }

        return result;
    }
}
