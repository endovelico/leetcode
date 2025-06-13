package solutions.p111;

import common.TreeNode;

public class Solution {

    public int minDepth(TreeNode root) {
        int current_min_depth = 0;
        if (root == null) return current_min_depth;

        return depth_first_search(root, current_min_depth);
    }

    private int depth_first_search(TreeNode root, int current_min_depth) {

        if (root == null) return Integer.MAX_VALUE;

        int new_current_min_depth = current_min_depth + 1;

        return Math.min(depth_first_search(root.left, new_current_min_depth), depth_first_search(root.right, new_current_min_depth));
    }
}
