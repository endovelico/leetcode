package solutions.p203;

import common.ListNode;

public class Solution {

    public ListNode removeElements(ListNode head, int val) {

        ListNode reference_node = head;
        ListNode previous_node = null;

        while(head != null) {
            if(head.val == val) {
                if(previous_node == null) {
                    reference_node = head.next;
                } else {
                    previous_node.next = head.next;
                }
            } else {
                previous_node = head;
            }
            head = head.next;
        }

        return reference_node;
    }
}