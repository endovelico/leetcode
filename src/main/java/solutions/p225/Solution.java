package solutions.p225;

import java.util.LinkedList;
import java.util.Queue;
public class Solution {

    private Queue<Integer> straight_queue;
    private Queue<Integer> inverted_queue;

    public Solution() {

        straight_queue = new LinkedList<Integer>();
        inverted_queue = new LinkedList<Integer>();
    }

    public void push(int x) {

        if(straight_queue.isEmpty()) {

        }

    }

    public int pop() {

    }

    public int top() {

    }

    public boolean empty() {

    }

    public void migrate() {

    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */