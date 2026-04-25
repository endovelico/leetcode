package solutions.p965;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;

        int value = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.val != value) {
                return false;
            }

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return true;
    }



    // DFS is shorter
    private boolean dfs(TreeNode node, int value) {
        if(node == null) return true;
        if(node.val != value) return false;

        return dfs(node.left, value) && dfs(node.right, value);
    }


}
