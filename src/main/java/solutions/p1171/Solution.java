package solutions.p1171;

import common.ListNode;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {

        // Dummy node handles zero-sum sequences at the beginning
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Map<Integer, ListNode> map = new HashMap<>();

        int sum = 0;
        ListNode current = dummy;

        // First pass:
        // Store the LAST node where each prefix sum occurs.
        while (current != null) {
            sum += current.val;
            map.put(sum, current);
            current = current.next;
        }

        // Second pass:
        // Use the map to skip zero-sum sections.
        sum = 0;
        current = dummy;

        while (current != null) {
            sum += current.val;

            current.next = map.get(sum).next;

            current = current.next;
        }

        return dummy.next;
    }
}