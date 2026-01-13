package solutions.p70;


import java.util.ArrayList;
import java.util.HashMap;

class MemoetizedSolution {

        int[] memo;

        public int climbStairs(int n) {
            memo = new int[n + 1];
            return dfs(n);
        }

        private int dfs(int n) {

            // base cases (same as naive)
            if (n == 1) return 1;
            if (n == 2) return 2;

            // if already solved, reuse it
            if (memo[n] != 0) {
                return memo[n];
            }

            // otherwise, compute and store
            memo[n] = dfs(n - 1) + dfs(n - 2);
            return memo[n];
        }
    }

