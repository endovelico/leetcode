package solutions.p255;

import java.util.*;

class MyStack {
    private Queue<Integer> q = new LinkedList<>();

    public void push(int x) {
        System.out.println("PUSH " + x);
        q.offer(x);
        System.out.println("  After enqueue: " + q);
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            int moved = q.poll();
            q.offer(moved);
            System.out.println("  Rotate: moved " + moved + " → " + q);
        }
    }

    public int pop() {
        int removed = q.poll();
        System.out.println("POP → " + removed + ", Queue now: " + q);
        return removed;
    }

    public int top() {
        int top = q.peek();
        System.out.println("TOP → " + top);
        return top;
    }

    public boolean empty() {
        boolean isEmpty = q.isEmpty();
        System.out.println("EMPTY? → " + isEmpty);
        return isEmpty;
    }

    public void printQueue() {
        System.out.println("Current Queue (Stack): " + q);
    }
}

public class MyStackTest {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.printQueue();

        stack.pop();         // should be 3
        stack.top();         // should be 2
        stack.pop();         // should be 2
        stack.push(4);
        stack.printQueue();

        stack.top();         // should be 4
        stack.empty();       // should be false
        stack.pop();         // should be 4
        stack.pop();         // should be 1
        stack.empty();       // should be true
    }
}
