package solutions.p104;

import common.TreeNode;

public class Solution {

    public int maxDepth(TreeNode root) {
        int current_max_depth = 0;
        if (root == null) return current_max_depth;

        return depth_first_search(root, current_max_depth);
    }

    private int depth_first_search(TreeNode root, int current_max_depth) {

        if (root == null) return current_max_depth;

        int new_current_max_depth = current_max_depth + 1;

        return Math.max(depth_first_search(root.left, new_current_max_depth), depth_first_search(root.right, new_current_max_depth));
    }
}

