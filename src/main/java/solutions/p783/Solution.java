package solutions.p783;

import common.TreeNode;

class Solution {
    private Integer prev = null;  // previous node value in in-order
    private int minDiff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        // left subtree
        inorder(node.left);

        // process current node
        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;

        // right subtree
        inorder(node.right);
    }
}

