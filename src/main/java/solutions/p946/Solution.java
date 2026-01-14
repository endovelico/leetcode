package solutions.p946;

import java.util.Stack;

import java.util.Stack;

class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();  // Stack to simulate push/pop
        int i = 0; // Pointer for the popped array

        // Iterate over each number in pushed
        for (int num : pushed) {
            stack.push(num); // Push the number onto the stack

            // While the stack is not empty AND top equals next needed pop
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop(); // Pop from the stack
                i++;         // Move to next element in popped
            }
        }

        // If stack is empty, all pops matched correctly
        return stack.isEmpty();
    }

}
