package solutions.p404;

import common.TreeNode;

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return preOrder(root, null);
    }

    private int preOrder(TreeNode node, TreeNode parent) {
        if (node == null) return 0;

        int sum = 0;

        // check if node is a left leaf
        if (node.left == null && node.right == null && parent != null && parent.left == node) {
            sum += node.val;
        }

        sum += preOrder(node.left, node);
        sum += preOrder(node.right, node);

        return sum;
    }
}