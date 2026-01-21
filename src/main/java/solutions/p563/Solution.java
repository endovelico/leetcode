package solutions.p563;

import common.TreeNode;

class Solution {

    int totalTilt = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return totalTilt;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftSum = dfs(node.left);
        int rightSum = dfs(node.right);

        totalTilt += Math.abs(leftSum - rightSum);

        return leftSum + rightSum + node.val;
    }
}
