package solutions.p817;

import common.ListNode;

import java.util.HashSet;

class Solution {

    public int numComponents(ListNode head, int[] nums) {

        // Put nums into a HashSet for O(1) lookup
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int componentCount = 0;
        boolean streak = false;

        ListNode curr = head;

        while (curr != null) {

            // Current node is part of nums
            if (set.contains(curr.val)) {

                // We just entered a new component
                if (!streak) {
                    componentCount++;
                    streak = true;
                }

                // Otherwise, we're continuing the same component

            } else {
                // We left a component
                streak = false;
            }

            curr = curr.next;
        }

        return componentCount;
    }
}