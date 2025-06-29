package solutions.p255;

import java.util.*;

class MyStack {
    private Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {

        queue.offer(x);  // Add to back

        int size = queue.size();
        // Rotate queue to make x appear at front
        for (int i = 0; i < size - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();  // Remove from front (top of stack)
    }

    public int top() {
        return queue.peek();  // Peek at front
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}