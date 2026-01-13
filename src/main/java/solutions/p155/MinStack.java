package solutions.p155;

class MinStack {

    private static class Node {
        int val;
        int minSoFar;
        Node next;

        Node(int val, int minSoFar, Node next) {
            this.val = val;
            this.minSoFar = minSoFar;
            this.next = next;
        }
    }

    private Node head;

    public MinStack() {}

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        } else {
            head = new Node(
                    val,
                    Math.min(val, head.minSoFar),
                    head
            );
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.minSoFar;
    }
}