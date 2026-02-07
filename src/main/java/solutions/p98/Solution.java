package solutions.p98;

import common.TreeNode;


class Solution {

    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode node, long minValue, long maxValue) {
        if (node == null) return true;

        if (node.val <= minValue || node.val >= maxValue) {
            return false;
        }

        return helper(node.left, minValue, node.val) &&
                helper(node.right, node.val, maxValue);
    }
}