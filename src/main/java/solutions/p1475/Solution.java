package solutions.p1475;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] finalPrices(int[] prices) {

        int n = prices.length;
        int[] result = prices.clone(); // copy original prices
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // While current price is <= stack top price
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int idx = stack.pop();
                result[idx] -= prices[i];
            }

            stack.push(i);
        }

        return result;
    }
}
