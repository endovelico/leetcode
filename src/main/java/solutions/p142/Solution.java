package solutions.p142;

import common.ListNode;

import java.util.HashSet;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> seen = new HashSet<>();

        ListNode curr = head;

        while (curr != null) {
            if (seen.contains(curr)) {
                return curr;
            }

            seen.add(curr);
            curr = curr.next;
        }

        return null;
    }
}
