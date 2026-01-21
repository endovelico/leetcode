package solutions.p1469;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> result_list = new ArrayList<>();
        dfs_transversal(root, result_list);
        return result_list;
    }

    private void dfs_transversal(TreeNode node, List<Integer> resultList) {
        if (node == null) return;

        // Check if left child is lonely
        if (node.left != null && node.right == null) resultList.add(node.left.val);

        // Check if right child is lonely
        if (node.right != null && node.left == null) resultList.add(node.right.val);

        // Recurse on both children
        dfs_transversal(node.left, resultList);
        dfs_transversal(node.right, resultList);
    }
}
