package solutions.p739;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class Solution {

    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // store indices

        for (int i = 0; i < n; i++) {
            // Pop days that are colder than current day
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }

            stack.push(i);
        }

        // Remaining indices in stack have 0 by default
        return result;
    }
}