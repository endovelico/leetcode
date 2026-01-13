package solutions.p322;

import java.util.Arrays;

class Solution {

    public int coinChange(int[] coins, int amount) {
        Integer[] minCoinsMemo = new Integer[amount + 1];

        int result = minCoins(amount, coins, minCoinsMemo);

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int minCoins(int remainingAmount,
                         int[] coins,
                         Integer[] minCoinsMemo) {

        // Base cases
        if (remainingAmount == 0) return 0;
        if (remainingAmount < 0) return Integer.MAX_VALUE;

        // Memoized result
        if (minCoinsMemo[remainingAmount] != null) {
            return minCoinsMemo[remainingAmount];
        }

        int minCoinsNeeded = Integer.MAX_VALUE;

        // Try every coin
        for (int coinValue : coins) {
            int resultForRest =
                    minCoins(remainingAmount - coinValue,
                            coins,
                            minCoinsMemo);

            if (resultForRest != Integer.MAX_VALUE) {
                minCoinsNeeded =
                        Math.min(minCoinsNeeded, resultForRest + 1);
            }
        }

        minCoinsMemo[remainingAmount] = minCoinsNeeded;
        return minCoinsNeeded;
    }
}
