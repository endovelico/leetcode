package solutions.p1111;

class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] ans = new int[n];
        int depth = 0;

        for (int i = 0; i < n; i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                depth++;
                ans[i] = depth % 2; // assign based on depth parity
            } else { // ')'
                ans[i] = depth % 2; // assign before decreasing
                depth--;
            }
        }

        return ans;
    }
}
