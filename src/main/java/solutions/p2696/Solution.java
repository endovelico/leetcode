package solutions.p2696;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int minLength(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            stack.push(c);

            if (stack.size() >= 2) {
                char top = stack.pop();
                char second = stack.peek();

                if ((second == 'A' && top == 'B') ||
                        (second == 'C' && top == 'D')) {
                    stack.pop(); // remove the matching pair
                } else {
                    stack.push(top); // restore
                }
            }
        }

        return stack.size();
    }
}
