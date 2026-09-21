package solutions.p2807;

import common.ListNode;

class Solution {

    public ListNode insertGreatestCommonDivisors(ListNode head) {

        ListNode current = head;

        while (current != null && current.next != null) {

            // Find GCD of current node and next node
            int divisor = gcd(current.val, current.next.val);

            // Create the new node
            ListNode newNode = new ListNode(divisor);

            // Insert it between current and current.next
            newNode.next = current.next;
            current.next = newNode;

            // Move to the original next node
            current = newNode.next;
        }

        return head;
    }

    private int gcd(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}