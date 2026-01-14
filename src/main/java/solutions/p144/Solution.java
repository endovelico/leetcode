package solutions.p144;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        preorder_transversal(root, result);

        return result;
    }

    public void preorder_transversal(TreeNode node, List<Integer> result_list) {
        if(node == null) return;

        result_list.add(node.val);
        preorder_transversal(node.left, result_list);
        preorder_transversal(node.right, result_list);

    }
}
