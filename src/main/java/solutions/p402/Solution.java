package solutions.p402;

import java.util.Deque;
import java.util.ArrayDeque;

class Solution {


    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        // Process each digit
        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && stack.peekLast() > digit && k > 0) {
                stack.pollLast(); // remove bigger digit
                k--;
            }
            stack.addLast(digit);
        }

        // If k > 0, remove remaining digits from end
        while (k > 0 && !stack.isEmpty()) {
            stack.pollLast();
            k--;
        }

        // Build result string
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }

        // Remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }


}
