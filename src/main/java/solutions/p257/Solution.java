package solutions.p257;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<String> allPaths = new ArrayList<>();
    // A temporary list to keep the current path nodes
    private List<String> currentPath = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        // Perform a depth-first search starting from the root
        depthFirstSearch(root);
        return allPaths;
    }

    private void depthFirstSearch(TreeNode node) {
        if (node == null) {
            // Base case: if node is null, do nothing
            return;
        }

        // Append current node's value to the path
        currentPath.add(String.valueOf(node.val));

        // If node is a leaf, add the path to the list of all paths
        if (node.left == null && node.right == null) {
            allPaths.add(String.join("->", currentPath));
        } else {
            // Recur for left and right children
            depthFirstSearch(node.left);
            depthFirstSearch(node.right);
        }

        // Backtrack: remove the last node from the path before returning
        currentPath.remove(currentPath.size() - 1);
    }
}
