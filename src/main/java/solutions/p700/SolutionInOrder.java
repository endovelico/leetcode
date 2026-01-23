package solutions.p700;

import common.TreeNode;

public class SolutionInOrder {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if (val < root.val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }

}
