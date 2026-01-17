package solutions.p39;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result_list = new ArrayList<>();
        backtrack_combination(0, candidates, target, new ArrayList<>(), result_list);
        return result_list;
    }

    private void backtrack_combination(int index, int[] candidates, int target, List<Integer> current_list, List<List<Integer>> resultList) {

        if (target == 0) { resultList.add(new ArrayList<>(current_list)); return; }
        if(target < 0) { return; }

        // Explore all candidates starting from index
        for (int i = index; i < candidates.length; i++) {

            // 1️⃣ Choose the element
            current_list.add(candidates[i]);

            // 2️⃣ Recurse: allow reuse of the same element
            backtrack_combination(i, candidates, target - candidates[i], current_list, resultList);

            // 3️⃣ Undo choice (backtrack)
            current_list.remove(current_list.size() - 1);
        }
    }
}