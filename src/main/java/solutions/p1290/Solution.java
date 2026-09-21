package solutions.p1290;

import common.ListNode;

class Solution {
    public int getDecimalValue(ListNode head) {

        int result = 0;

        while(head != null) {
            result = result * 2 + head.val;
            head = head.next;
        }

        return result;
    }
}
