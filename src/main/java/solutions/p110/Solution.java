package solutions.p110;

import common.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {

    //The problem presents a scenario where one is given a binary tree
    // and is tasked with determining if the tree is height-balanced.
    // In the context of this problem, a height-balanced binary tree is
    // defined as a binary tree where the heights of the two child subtrees
    // of any node differ by no more than one. Additionally,
    // the subtrees of any node must also be height-balanced.

    private static final int HEIGHT_SIGNIFIER = 0;
    private static final int CURRENT_NODE_SIGNIFIER = 1;

    public boolean isBalanced(TreeNode root) {

        // A non-negative height indicates that the tree is balanced,
        // while -1 represents an imbalance.
        return calculate_height(root) >= HEIGHT_SIGNIFIER;
    }

    // Recursively calculates the height of a binary tree.
    // Returns -1 if the subtree is unbalanced.
    private int calculate_height(TreeNode node) {

        if(node == null) return 0;

        // Recursively find the height of the left and right subtrees.
        int left_height = calculate_height(node.left);
        int right_height = calculate_height(node.right);

        // Check if left or right subtree is unbalanced or if they differ in height by more than 1.
        if (left_height == -1 || right_height == -1 || Math.abs(left_height - right_height) > 1) {
            return -1; // Tree is not balanced.
        }

        // Current node height is max of left and right subtree heights plus 1 (for the current node).
        return CURRENT_NODE_SIGNIFIER + Math.max(left_height, right_height);
    }
}