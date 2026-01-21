package solutions.p112;


import common.TreeNode;

class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return dfs_traversal(root, targetSum, 0);
    }

    private boolean dfs_traversal(TreeNode node, int targetSum, int currentSum) {
        if (node == null) return false;

        currentSum += node.val;

        // Leaf node: check if the path sum equals target
        if (node.left == null && node.right == null) {
            return currentSum == targetSum;
        }

        // DFS left and right subtrees
        return dfs_traversal(node.left, targetSum, currentSum) ||
                dfs_traversal(node.right, targetSum, currentSum);
    }
}
