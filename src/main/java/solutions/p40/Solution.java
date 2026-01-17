package solutions.p40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result_list = new ArrayList<>();
        Arrays.sort(candidates); // sort to handle duplicates

        backtrack_combination(0, candidates, target, new ArrayList<>(), result_list);
        return result_list;
    }

    private void backtrack_combination(int index, int[] candidates, int target, List<Integer> current_list, List<List<Integer>> resultList) {

        if (target == 0) {
            resultList.add(new ArrayList<>(current_list));
            return;
        }

        if (target < 0) return; // prune

        for (int i = index; i < candidates.length; i++) {

            // skip duplicates
            if (i > index && candidates[i] == candidates[i - 1]) continue;

            current_list.add(candidates[i]); // pick current candidate
            backtrack_combination(i + 1, candidates, target - candidates[i], current_list, resultList); // i + 1 because cannot reuse
            current_list.remove(current_list.size() - 1); // backtrack
        }
    }
}
