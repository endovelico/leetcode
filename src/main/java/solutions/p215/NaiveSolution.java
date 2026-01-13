package solutions.p215;

import java.util.Arrays;

public class NaiveSolution {

    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);   // ascending order

        return nums[nums.length - k];
    }
}
