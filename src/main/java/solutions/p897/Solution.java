package solutions.p897;

import common.TreeNode;

public class Solution {

    private TreeNode prev = null;  // keeps track of the previous node in in-order
    private TreeNode newRoot = null; // the new root of the increasing tree

    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return newRoot;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        // left subtree
        inorder(node.left);

        // process current node
        if (prev == null) {
            newRoot = node; // first node in in-order becomes new root
        } else {
            prev.right = node; // link previous node's right to current
        }
        node.left = null; // remove left link
        prev = node; // update previous

        // right subtree
        inorder(node.right);
    }
}
