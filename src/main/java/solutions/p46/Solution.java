package solutions.p46;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), result, visited);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result, boolean[] visited) {

        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // permutation complete
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue; // skip if already used
            visited[i] = true;
            current.add(nums[i]);
            backtrack(nums, current, result, visited);
            current.remove(current.size() - 1); // backtrack
            visited[i] = false;
        }
    }
}
