package solutions.p216;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int k, int remaining, List<Integer> path, List<List<Integer>> res) {
        // Base case: valid combination
        if (path.size() == k && remaining == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // Stop recursion if path too long or sum exceeded
        if (path.size() > k || remaining < 0) {
            return;
        }

        // Try all candidates from start to 9
        for (int i = start; i <= 9; i++) {
            path.add(i);                         // choose
            backtrack(i + 1, k, remaining - i, path, res); // explore
            path.remove(path.size() - 1);        // un-choose (backtrack)
        }
    }
}
