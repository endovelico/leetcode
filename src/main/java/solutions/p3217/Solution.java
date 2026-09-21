package solutions.p3217;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {

        // Put values to delete into a HashSet
        Set<Integer> valuesToDelete = new HashSet<>();

        for (int num : nums) {
            valuesToDelete.add(num);
        }

        // Dummy node handles deleting the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy;

        while (current.next != null) {

            if (valuesToDelete.contains(current.next.val)) {
                // Delete current.next
                current.next = current.next.next;
            } else {
                // Only move forward if we didn't delete
                current = current.next;
            }
        }

        return dummy.next;
    }
}