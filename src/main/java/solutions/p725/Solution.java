package solutions.p725;

import common.ListNode;

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {

        // 1. Find the length of the linked list
        int length = 0;
        ListNode curr = head;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

        // 2. Calculate the size of each part
        int baseSize = length / k;
        int remainder = length % k;

        ListNode[] result = new ListNode[k];

        curr = head;

        // 3. Build each part
        for (int i = 0; i < k; i++) {

            result[i] = curr;

            // First 'remainder' parts get one extra node
            int partSize = baseSize;

            if (i < remainder) {
                partSize++;
            }

            // 4. Move to the end of this part
            for (int j = 1; j < partSize; j++) {
                curr = curr.next;
            }

            // 5. Cut the part from the remaining list
            if (curr != null) {
                ListNode nextPart = curr.next;
                curr.next = null;
                curr = nextPart;
            }
        }

        return result;
    }
}