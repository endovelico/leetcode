package solutions.p872;

import common.TreeNode;

import java.util.List;
import java.util.ArrayList;

class Solution {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        dfs(root1, list1);
        dfs(root2, list2);

        return list1.equals(list2);
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) return;

        // leaf node
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }

        dfs(node.left, list);
        dfs(node.right, list);
    }
}