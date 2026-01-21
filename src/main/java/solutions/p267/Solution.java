package solutions.p267;

import java.util.*;

class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        Map<Character, Integer> countMap = new HashMap<>();

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        // Check if palindrome is possible & prepare half string
        StringBuilder half = new StringBuilder();
        char middle = 0; // the middle character if length is odd
        int oddCount = 0;

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            char c = entry.getKey();
            int freq = entry.getValue();

            if (freq % 2 != 0) {
                oddCount++;
                middle = c;
                if (oddCount > 1) return res; // impossible to form palindrome
            }

            for (int i = 0; i < freq / 2; i++) {
                half.append(c); // only half of each char
            }
        }

        char[] halfArr = half.toString().toCharArray();
        Arrays.sort(halfArr); // sort to handle duplicates
        boolean[] visited = new boolean[halfArr.length];

        backtrack(halfArr, visited, new StringBuilder(), middle, res);
        return res;
    }

    private void backtrack(char[] halfArr, boolean[] visited, StringBuilder path, char middle, List<String> res) {
        if (path.length() == halfArr.length) {
            // Build full palindrome: half + middle + reverse(half)
            StringBuilder rev = new StringBuilder(path).reverse();
            String palindrome = path.toString() + (middle == 0 ? "" : middle) + rev.toString();
            res.add(palindrome);
            return;
        }

        for (int i = 0; i < halfArr.length; i++) {
            if (visited[i]) continue;

            // Skip duplicates
            if (i > 0 && halfArr[i] == halfArr[i - 1] && !visited[i - 1]) continue;

            visited[i] = true;
            path.append(halfArr[i]);
            backtrack(halfArr, visited, path, middle, res);
            path.deleteCharAt(path.length() - 1);
            visited[i] = false;
        }
    }
}
