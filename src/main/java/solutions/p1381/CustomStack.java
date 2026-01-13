package solutions.p1381;

class CustomStack {
    class Node {
        int val;
        Node next;
        Node prev;
        Node(int val) { this.val = val; }
    }

    Node head; // bottom
    Node tail; // top
    int size;
    int maxSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        head = tail = null;
    }

    public void push(int x) {
        if (size == maxSize) return;
        Node node = new Node(x);
        if (tail == null) { // empty
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public int pop() {
        if (tail == null) return -1;
        int val = tail.val;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null; // stack empty
        size--;
        return val;
    }

    public void increment(int k, int val) {
        Node curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr.val += val;
            curr = curr.next;
            count++;
        }
    }
}
