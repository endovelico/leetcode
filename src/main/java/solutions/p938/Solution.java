package solutions.p938;

import common.TreeNode;

public class Solution {

    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

    private int dfs(TreeNode node, int low, int high) {
        if (node == null) return 0;

        int sum = 0;

        // Include current node if it is in range
        if (node.val >= low && node.val <= high) {
            sum += node.val;
        }

        // Recur for left and right subtrees
        sum += dfs(node.left, low, high);
        sum += dfs(node.right, low, high);

        return sum;
    }
}

