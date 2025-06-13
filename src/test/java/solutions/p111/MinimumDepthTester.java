package solutions.p111;

import common.TreeNode;

public class MinimumDepthTester {
    // Helper method to build test case 1: Balanced binary tree
    public static TreeNode buildTestTree1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }

    // Helper method to build test case 2: Skewed to the right
    public static TreeNode buildTestTree2() {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        return root;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();  // Assuming class is named 'Solution'

        TreeNode test1 = buildTestTree1();
        TreeNode test2 = buildTestTree2();
        TreeNode test3 = null;  // Empty tree
        TreeNode test4 = new TreeNode(1);  // Single node

        System.out.println("Test 1: Expected = 2, Actual = " + solver.minDepth(test1));
        System.out.println("Test 2: Expected = 4, Actual = " + solver.minDepth(test2));
        System.out.println("Test 3: Expected = 0, Actual = " + solver.minDepth(test3));
        System.out.println("Test 4: Expected = 1, Actual = " + solver.minDepth(test4));
    }
}
