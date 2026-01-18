package solutions.p254;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(2, n, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int n, List<Integer> path, List<List<Integer>> res) {
        for (int i = start; i <= n / 2; i++) {
            if (n % i == 0) {
                path.add(i);                   // choose
                backtrack(i, n / i, path, res);// recurse
                path.remove(path.size() - 1);  // unchoose
            }
        }

        // Only save path + remaining n if it forms a non-decreasing combination
        if (!path.isEmpty() && n >= start) {
            path.add(n);
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
        }
    }
}
