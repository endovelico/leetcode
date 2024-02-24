package solutions.p2;

import common.ListNode;

public class Solution {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode l1_head = l1;
        int to_add = 0;

        while(to_add != 0 || l2 != null) {

            int node_val_sum = l2 != null ? l1.val + l2.val + to_add : l1.val + to_add;
            int ms_sum_digit = node_val_sum / 10;
            int ls_sum_digit = node_val_sum  % 10;

            l1.val = ls_sum_digit;
            to_add = ms_sum_digit;

            if(l1.next == null && (to_add != 0 || (l2 != null && l2.next != null))) l1.next = new ListNode(0); //AQUI
            if(l2 != null) l2 = l2.next;

            l1 = l1.next;
        }

        return l1_head;
    }
}
