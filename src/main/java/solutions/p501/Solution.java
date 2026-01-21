package solutions.p501;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private Integer previous = null;
    private int count = 0;
    private int maxCount = 0;
    private List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);
        return modes.stream().mapToInt(i -> i).toArray();
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        // process current node
        if (previous == null || node.val != previous) {
            count = 1;
        } else {
            count++;
        }

        if (count > maxCount) {
            modes.clear();
            modes.add(node.val);
            maxCount = count;
        } else if (count == maxCount) {
            modes.add(node.val);
        }

        previous = node.val;

        inorder(node.right);
    }
}
