package solutions.p707;

import common.DoubleLinkListNode;
import common.ListNode;

class MyLinkedList {

    class DoubleLinkListNode {
        int val;
        DoubleLinkListNode prev;
        DoubleLinkListNode next;

        DoubleLinkListNode() {}
        DoubleLinkListNode(int val) { this.val = val; }
    }

    private DoubleLinkListNode head;
    private DoubleLinkListNode tail;
    private int size;

    public MyLinkedList() {
        head = new DoubleLinkListNode();  // dummy head
        tail = new DoubleLinkListNode();  // dummy tail
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // Get the value at index-th node. Return -1 if invalid
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        DoubleLinkListNode curr = head.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    // Add at head
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    // Add at tail
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    // Add at index
    public void addAtIndex(int index, int val) {
        if (index < 0) index = 0;
        if (index > size) return;

        DoubleLinkListNode newNode = new DoubleLinkListNode(val);
        DoubleLinkListNode curr = head;
        // Move to the node **before** the insertion point
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        // Insert newNode between curr and curr.next
        newNode.next = curr.next;
        newNode.prev = curr;
        curr.next.prev = newNode;
        curr.next = newNode;

        size++;
    }

    // Delete at index
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        DoubleLinkListNode curr = head.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        // Remove curr
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;

        size--;
    }
}
