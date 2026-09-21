package solutions.p382;

import common.ListNode;

import java.util.Random;

class Solution {
    private ListNode head;
    private Random random;

    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {
        ListNode current = head;
        int result = 0;
        int i = 1;

        while (current != null) {
            // Pick current node with probability 1/i
            if (random.nextInt(i) == 0) {
                result = current.val;
            }

            current = current.next;
            i++;
        }

        return result;
    }
}
