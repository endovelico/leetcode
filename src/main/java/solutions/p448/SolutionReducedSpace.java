package solutions.p448;

import java.util.ArrayList;
import java.util.List;

class SolutionReducedSpace {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missing = new ArrayList<>();

        // Mark numbers as negative to indicate presence
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;  // map num → index
            nums[index] = -Math.abs(nums[index]); // mark as seen
        }

        // Find positive numbers → missing numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing.add(i + 1);
            }
        }

        return missing;
    }
}
