package solutions.p232;

import java.util.Stack;


public class MyQueue {
    private Stack<Integer> stack = new Stack<>();

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }

        // Save current top and pop it
        int top = stack.pop();

        // Recursively push to bottom
        push(x);

        // Restore the saved top
        stack.push(top);
    }

    public int pop() {
        return stack.pop();  // FIFO simulated
    }

    public int peek() {
        return stack.peek(); // Front of the queue
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
