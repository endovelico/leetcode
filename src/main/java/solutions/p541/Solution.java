package solutions.p541;

class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        for (int start = 0; start < n; start += 2 * k) {
            int i = start;
            int j = Math.min(start + k - 1, n - 1); // handle end of string
            // reverse chars[i..j]
            while (i < j) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }

        return new String(chars);
    }
}