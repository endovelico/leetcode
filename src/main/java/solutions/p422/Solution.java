package solutions.p422;

import java.util.List;

import java.util.List;

public class Solution {
    public boolean validWordSquare(List<String> words) {
        int n = words.size();

        for (int i = 0; i < n; i++) {
            String row = words.get(i);
            for (int j = 0; j < row.length(); j++) {
                // Check if the j-th row exists
                if (j >= n) return false;

                String col = words.get(j);

                // Check if the i-th column exists in row j
                if (i >= col.length()) return false;

                // Compare characters
                if (row.charAt(j) != col.charAt(i)) return false;
            }
        }

        return true;
    }
}
