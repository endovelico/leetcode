package solutions.p543;

import common.TreeNode;

class Solution {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;

        int left = depth(node.left);
        int right = depth(node.right);

        // candidate diameter through this node
        diameter = Math.max(diameter, left + right);

        // height to parent
        return Math.max(left, right) + 1;
    }
}
