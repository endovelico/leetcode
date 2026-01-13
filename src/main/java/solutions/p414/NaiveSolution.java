package solutions.p414;

import java.util.Arrays;

class NaiveSolution {
    public int thirdMax(int[] nums) {

        Arrays.sort(nums); // ascending

        int distinctCount = 1;
        int last = nums[nums.length - 1];

        // walk from second largest downwards
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != last) {
                distinctCount++;
                last = nums[i];

                if (distinctCount == 3) {
                    return last;
                }
            }
        }

        // fewer than 3 distinct values
        return nums[nums.length - 1];
    }
}
