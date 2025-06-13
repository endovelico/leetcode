package solutions.p111;

import common.TreeNode;

public class Solution {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return depth_first_search(root);
    }

    private int depth_first_search(TreeNode node) {
        if (node == null) return Integer.MAX_VALUE;

        // If it's a leaf node
        if (node.left == null && node.right == null) return 1;

        int leftDepth = depth_first_search(node.left);
        int rightDepth = depth_first_search(node.right);

        return 1 + Math.min(leftDepth, rightDepth);
    }
}
