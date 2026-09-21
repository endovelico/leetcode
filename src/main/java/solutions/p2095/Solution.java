package solutions.p2095;

import common.ListNode;

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // If there is only one node
        if (head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is now the middle node
        prev.next = slow.next;

        return head;
    }
}
