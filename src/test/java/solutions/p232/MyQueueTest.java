package solutions.p232;

public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        queue.push(3);

        queue.peek();    // should be 1
        queue.pop();     // removes 1
        queue.peek();    // should be 2

        queue.push(4);
        queue.pop();     // removes 2
        queue.pop();     // removes 3
        queue.peek();    // should be 4

        queue.empty();   // false
        queue.pop();     // removes 4
        queue.empty();   // true
    }
}
