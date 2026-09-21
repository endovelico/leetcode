package solutions.p1721;

import common.ListNode;

class Solution {
    public ListNode swapNodes(ListNode head, int k) {

        // first = kth node from the beginning
        ListNode first = head;

        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        // second will eventually be the kth node from the end
        ListNode second = head;
        ListNode fast = first;

        // Move fast to the end while moving second
        while (fast.next != null) {
            fast = fast.next;
            second = second.next;
        }

        // Swap the values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }
}