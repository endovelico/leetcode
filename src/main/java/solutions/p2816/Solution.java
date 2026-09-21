package solutions.p2816;

import common.ListNode;

class Solution {

    public ListNode doubleIt(ListNode head) {

        int carry = doubleNumber(head);

        if (carry > 0) {
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            head = newHead;
        }

        return head;
    }

    private int doubleNumber(ListNode node) {

        if (node == null) {
            return 0;
        }

        int carry = doubleNumber(node.next);

        int value = node.val * 2 + carry;

        node.val = value % 10;

        return value / 10;
    }
}