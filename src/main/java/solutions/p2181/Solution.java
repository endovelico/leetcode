package solutions.p2181;

import common.ListNode;

class Solution {
    public ListNode mergeNodes(ListNode head) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        int sum = 0;
        ListNode curr = head.next; // skip the first 0

        while (curr != null) {

            if (curr.val == 0) {
                // End of a group
                tail.next = new ListNode(sum);
                tail = tail.next;

                sum = 0;
            } else {
                // Add value to current group
                sum += curr.val;
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}