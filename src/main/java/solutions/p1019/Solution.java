package solutions.p1019;

import common.ListNode;

import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public int[] nextLargerNodes(ListNode head) {

        // Convert linked list to ArrayList
        ArrayList<Integer> values = new ArrayList<>();

        ListNode current = head;

        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        int[] result = new int[values.size()];

        // Stack stores indexes
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < values.size(); i++) {

            // Current value is greater than values at these indexes
            while (!stack.isEmpty() && values.get(i) > values.get(stack.peek())) {

                int index = stack.pop();
                result[index] = values.get(i);
            }

            // Current index hasn't found its greater value yet
            stack.push(i);
        }

        return result;
    }
}