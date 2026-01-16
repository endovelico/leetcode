package solutions.p71;

import java.util.Stack;

class Solution {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                // Skip empty parts and current directory
                continue;
            } else if (part.equals("..")) {
                // Go to parent directory if stack is not empty
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Valid directory name, push to stack
                stack.push(part);
            }
        }

        // Build simplified path from stack
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        // If stack is empty, return root
        return result.length() > 0 ? result.toString() : "/";
    }


}
