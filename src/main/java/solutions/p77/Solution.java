package solutions.p77;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int n, int k,
                           List<Integer> path,
                           List<List<Integer>> res) {

        // base case
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);              // choose
            backtrack(i + 1, n, k, path, res); // explore
            path.remove(path.size() - 1); // unchoose
        }
    }
}
