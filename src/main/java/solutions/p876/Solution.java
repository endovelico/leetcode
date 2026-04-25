package solutions.p876;

import common.ListNode;

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Fast moves 2 steps, slow moves 1 step
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // When fast reaches the end, slow is at the middle
        return slow;
    }
}