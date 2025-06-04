package solutions.p226;

import common.TreeNode;

public class Tester {

    public static void main(String[] args) {
        // Create test tree:
        //       4
        //     /   \
        //    2     7
        //   / \   / \
        //  1   3 6   9

        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));

        System.out.println("Before inversion (In-Order):");
        printInOrder(root);

        Solution solution = new Solution();
        TreeNode inverted = solution.invertTree(root);

        System.out.println("\nAfter inversion (In-Order):");
        printInOrder(inverted);
    }

    private static void printInOrder(TreeNode node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }
}
