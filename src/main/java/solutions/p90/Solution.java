package solutions.p90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> result_list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        backtracking_subsets(0, nums, new ArrayList<Integer>(), result_list);
        return result_list;
    }

    private void backtracking_subsets(int index,
                                      int[] ordered_numbers,
                                      ArrayList<Integer> current_list,
                                      List<List<Integer>> result_list) {

        result_list.add(new ArrayList<>(current_list)); // save current subset

        for (int i = index; i < ordered_numbers.length; i++) {
            // Skip duplicates
            if (i > index && ordered_numbers[i] == ordered_numbers[i - 1]) continue;

            current_list.add(ordered_numbers[i]);                     // choose
            backtracking_subsets(i + 1, ordered_numbers, current_list, result_list); // explore
            current_list.remove(current_list.size() - 1);         // un-choose
        }


    }
}