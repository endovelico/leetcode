package solutions.p47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.*;

class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);                  // 1️⃣ sort to group duplicates
        boolean[] visited = new boolean[nums.length];

        backtrack(nums, visited, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(
            int[] nums,
            boolean[] visited,
            List<Integer> current,
            List<List<Integer>> result) {

        // 2️⃣ Base case: full permutation built
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // 3️⃣ Try each unused number
        for (int i = 0; i < nums.length; i++) {

            // already used in this permutation
            if (visited[i]) continue;

            // skip duplicates (critical line)
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;

            // choose
            visited[i] = true;
            current.add(nums[i]);

            // explore
            backtrack(nums, visited, current, result);

            // unchoose
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}
