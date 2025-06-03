package solutions.p110;

import common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Tester {

    // Helper method to build a binary tree from an array representation.
    private TreeNode buildTree(Integer[] values) {
        if (values.length == 0 || values[0] == null) return null;
        TreeNode[] nodes = new TreeNode[values.length];
        nodes[0] = new TreeNode(values[0]);
        for (int i = 1; i < values.length; i++) {
            if (values[i] != null) {
                nodes[i] = new TreeNode(values[i]);
                int parentIndex = (i - 1) / 2;
                if (i % 2 == 1) {
                    nodes[parentIndex].left = nodes[i];
                } else {
                    nodes[parentIndex].right = nodes[i];
                }
            }
        }
        return nodes[0];
    }

    @Test
    void testBalancedTree() {
        Solution solution = new Solution();
        // Constructing the following balanced binary tree:
        //       3
        //      / \
        //     9  20
        //        / \
        //       15  7
        Integer[] treeValues = {3, 9, 20, null, null, 15, 7};
        TreeNode root = buildTree(treeValues);
        assertTrue(solution.isBalanced(root));
    }

    @Test
    void testUnbalancedTree() {
        Solution solution = new Solution();
        // Constructing the following unbalanced binary tree:
        //       1
        //      /
        //     2
        //    /
        //   3
        Integer[] treeValues = {1, 2, null, 3};
        TreeNode root = buildTree(treeValues);
        assertFalse(solution.isBalanced(root));
    }

    @Test
    void testEmptyTree() {
        Solution solution = new Solution();
        TreeNode root = null;
        assertTrue(solution.isBalanced(root));
    }

    @Test
    void testSingleNodeTree() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        assertTrue(solution.isBalanced(root));
    }

    @Test
    void testSlightlyUnbalancedTree() {
        Solution solution = new Solution();
        // Constructing the following tree:
        //       1
        //      / \
        //     2   2
        //    /
        //   3
        Integer[] treeValues = {1, 2, 2, 3};
        TreeNode root = buildTree(treeValues);
        assertTrue(solution.isBalanced(root));
    }

    @Test
    void testDeepUnbalancedTree() {
        Solution solution = new Solution();
        // Constructing the following tree:
        //       1
        //      / \
        //     2   2
        //    /
        //   3
        //  /
        // 4
        Integer[] treeValues = {1, 2, 2, 3, null, null, null, 4};
        TreeNode root = buildTree(treeValues);
        assertFalse(solution.isBalanced(root));
    }
}
