package solutions.p2130;

import common.ListNode;
import java.util.ArrayList;

class Solution {

    public int pairSum(ListNode head) {

        // Store all node values
        ArrayList<Integer> values = new ArrayList<>();

        ListNode current = head;

        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        // Find the maximum twin sum
        int maxSum = 0;

        int left = 0;
        int right = values.size() - 1;

        while (left < right) {

            int sum = values.get(left) + values.get(right);

            if (sum > maxSum) {
                maxSum = sum;
            }

            left++;
            right--;
        }

        return maxSum;
    }
}