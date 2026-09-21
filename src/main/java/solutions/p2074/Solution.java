package solutions.p2074;

import common.ListNode;

class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;

        int groupSize = 2;

        while (curr != null) {
            // Find the actual length of this group
            int count = 0;
            ListNode temp = curr;

            while (temp != null && count < groupSize) {
                temp = temp.next;
                count++;
            }

            // If the group length is even, reverse it
            if (count % 2 == 0) {
                ListNode groupStart = curr;
                ListNode nextGroup = temp;

                ListNode prevNode = nextGroup;
                ListNode currNode = curr;

                for (int i = 0; i < count; i++) {
                    ListNode next = currNode.next;
                    currNode.next = prevNode;
                    prevNode = currNode;
                    currNode = next;
                }

                // Connect previous group to reversed group
                prev.next = prevNode;

                // groupStart is now the last node
                prev = groupStart;
                curr = nextGroup;
            } else {
                // Group isn't reversed
                for (int i = 0; i < count; i++) {
                    prev = curr;
                    curr = curr.next;
                }
            }

            groupSize++;
        }

        return head;
    }
}
