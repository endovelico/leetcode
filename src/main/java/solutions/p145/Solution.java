package solutions.p145;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode node, List<Integer> result) {
        if (node == null) return;        // Base case

        postorder(node.left, result);    // Visit left
        postorder(node.right, result);   // Visit right
        result.add(node.val);            // Visit root
    }
}
