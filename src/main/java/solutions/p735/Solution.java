package solutions.p735;

import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            boolean destroyed = false;

            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                if (stack.peek() < -a) {
                    stack.pop(); // top exploded, continue checking
                } else if (stack.peek() == -a) {
                    stack.pop(); // both explode
                    destroyed = true;
                    break;
                } else { // top is bigger
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(a);
            }
        }

        // Convert stack to array (preserve bottom → top order)
        int n = stack.size();
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

}

