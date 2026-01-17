package solutions.p78;

import java.util.ArrayList;
import java.util.List;


class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        // At each step, add the current subset to the result
        result.add(new ArrayList<>(current));

        // Explore further elements
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);             // Choose element nums[i]
            backtrack(nums, i + 1, current, result); // Explore further with this choice
            current.remove(current.size() - 1); // Undo choice (backtrack)
        }
    }


}