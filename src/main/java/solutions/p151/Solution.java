package solutions.p151;

import java.util.Stack;

import java.util.*;

class Solution {
    public String reverseWords(String s) {
        // Edge case: empty or single character string
        if (s == null || s.length() <= 1) return s.trim();

        Stack<String> reverseWordStack = new Stack<>();

        // 1️⃣ Split string into words, ignoring multiple spaces
        // trim() removes leading/trailing spaces
        // \\s+ regex matches 1 or more spaces
        String[] words = s.trim().split("\\s+");

        // 2️⃣ Push each word onto the stack
        for (String word : words) {
            reverseWordStack.push(word);
        }

        // 3️⃣ Pop words from stack to build reversed string
        StringBuilder sb = new StringBuilder();
        while (!reverseWordStack.isEmpty()) {
            sb.append(reverseWordStack.pop());
            if (!reverseWordStack.isEmpty()) sb.append(" "); // Add space between words
        }

        return sb.toString();
    }
}