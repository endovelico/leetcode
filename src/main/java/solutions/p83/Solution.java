package solutions.p83;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode reference_head = head;
        ListNode previous_node = null;
        Set<Integer> value_set = new HashSet<Integer>();

        while (head != null) {

            if (value_set.contains(head.val)) {
                previous_node.next = head.next;
            } else {
                value_set.add(head.val);
                previous_node = head;
            }

            head = head.next;
        }

        return reference_head;

    }

    public static void main(String []args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(1);
        ListNode three = new ListNode(1);
       // ListNode four = new ListNode(3);
       // ListNode five = new ListNode(3);

        one.next = two;
        two.next = three;
        //three.next = four;
        //four.next = five;

        Solution solution = new Solution();
        solution.deleteDuplicates(one);
    }
}
