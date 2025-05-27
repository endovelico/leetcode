package solutions.p222;

import common.TreeNode;

//https://algo.monster/liteproblems/222
public class Solution {

    //If the left and right depths are equal (left == right),
    // according to the properties of complete binary trees,
    // the left subtree is perfect and contains 2^left - 1 nodes.
    // We then add 1 (the root node) to this number and recursively count the nodes
    //  in the right subtree.

    //If the left and right depths are not equal, the last level is not fully filled,
    // so the perfect subtree is the right subtree with 2^right - 1 nodes.
    // We again add 1 for the root node and recursively count the nodes in the left
    // subtree.

    //In both cases, the expression (1 << left) or (1 << right) is used to calculate
    // (2^\text{left}) or (2^\text{right}) respectively.
    // This bit-shift operation is a fast way to compute powers of two.

    // Method that returns the count of nodes in a complete binary tree.
    public int countNodes(TreeNode root) {
        // Base case: if the tree is empty, return 0
        if (root == null) {
            return 0;
        }

        // Compute the depth of the left subtree
        int leftDepth = computeDepth(root.left);
        // Compute the depth of the right subtree
        int rightDepth = computeDepth(root.right);

        // Check if the left and right depths are equal
        if (leftDepth == rightDepth) {
            // If equal, the left subtree is complete and we add its node count to the recursive count of the right subtree
            return (1 << leftDepth) + countNodes(root.right);
        } else {
            // If not equal, the right subtree is complete and we add its node count to the recursive count of the left subtree
            return (1 << rightDepth) + countNodes(root.left);
        }
    }

    // Helper method that computes the depth of the tree (distance from the root to the deepest leaf node)
    private int computeDepth(TreeNode root) {
        int depth = 0;
        // Loop to travel down the left edge of the tree until a null is encountered
        for (; root != null; root = root.left) {
            depth++;
        }
        // Return the depth of the tree
        return depth;
    }


}
