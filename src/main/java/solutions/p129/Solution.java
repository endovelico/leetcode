package solutions.p129;

import common.TreeNode;

class Solution {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        if (node == null) return 0;

        // Update the path value: shift previous digits left and add current node
        currentSum = currentSum * 10 + node.val;

        // If leaf, return the path value
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // Sum values from left and right subtrees
        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }

}
