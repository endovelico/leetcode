package solutions.p977;

import java.util.Arrays;

class SolutionNaive {
    public int[] sortedSquares(int[] nums) {

        for(int cursor = 0; cursor < nums.length; cursor++) {

            nums[cursor] *= nums[cursor];

        }

        Arrays.sort(nums);
        return nums;
    }
}