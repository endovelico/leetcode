package solutions.p110;

import common.TreeNode;
import markdown.MarkdownUtils;

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

    public static void main(String[] args) {

        MarkdownUtils.printMarkdownToConsole("Here’s a complete **Markdown guide** for the [AlgoMonster Problem #110 – Balanced Binary Tree](https://algo.monster/liteproblems/110), including intuition, approach, time/space complexity, and practical tips:\n" +
                "\n" +
                "---\n" +
                "\n" +
                "````markdown\n" +
                "# \uD83E\uDDE0 Problem #110: Balanced Binary Tree\n" +
                "\n" +
                "## \uD83D\uDCD8 Problem Statement\n" +
                "Determine if a binary tree is **height-balanced**. A tree is height-balanced if, for every node, the difference in height between the left and right subtree is at most 1.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## \uD83D\uDCA1 Intuition\n" +
                "\n" +
                "To check if a tree is balanced:\n" +
                "- For every node, compare the height of the left and right subtrees.\n" +
                "- If the height difference > 1, it's not balanced.\n" +
                "- The challenge is doing this **efficiently**, avoiding repeated computations.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## \uD83D\uDEE0\uFE0F Optimal Approach: DFS with Early Termination\n" +
                "\n" +
                "Use **post-order traversal** (left → right → root) and return:\n" +
                "- The height if the subtree is balanced.\n" +
                "- `-1` if it's not balanced (early termination).\n" +
                "\n" +
                "### ✅ Why this works:\n" +
                "Instead of recalculating height multiple times, we compute it bottom-up and short-circuit if imbalance is detected.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## \uD83D\uDD0D Algorithm Steps\n" +
                "\n" +
                "1. Define a recursive function `check(node)`:\n" +
                "   - If `node` is null, return 0.\n" +
                "   - Recursively get height of left and right subtrees.\n" +
                "   - If either is `-1`, propagate `-1` upward.\n" +
                "   - If `abs(left - right) > 1`, return `-1`.\n" +
                "   - Else, return `1 + max(left, right)`.\n" +
                "\n" +
                "2. Call `check(root)` in the main function and check if result is `-1`.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## \uD83E\uDDEA Code Example (Java)\n" +
                "\n" +
                "```java\n" +
                "class Solution {\n" +
                "    public boolean isBalanced(TreeNode root) {\n" +
                "        return check(root) != -1;\n" +
                "    }\n" +
                "\n" +
                "    private int check(TreeNode node) {\n" +
                "        if (node == null) return 0;\n" +
                "\n" +
                "        int left = check(node.left);\n" +
                "        if (left == -1) return -1;\n" +
                "\n" +
                "        int right = check(node.right);\n" +
                "        if (right == -1) return -1;\n" +
                "\n" +
                "        if (Math.abs(left - right) > 1) return -1;\n" +
                "\n" +
                "        return 1 + Math.max(left, right);\n" +
                "    }\n" +
                "}\n" +
                "````\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## ⏱\uFE0F Time and Space Complexity\n" +
                "\n" +
                "| Complexity | Value | Explanation                                                                   |\n" +
                "| ---------- | ----- | ----------------------------------------------------------------------------- |\n" +
                "| ⌛ Time     | O(n)  | Every node is visited **once**                                                |\n" +
                "| \uD83E\uDDE0 Space   | O(h)  | Max recursion depth is the tree height (O(log n) if balanced, O(n) if skewed) |\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## ⚠\uFE0F Edge Cases\n" +
                "\n" +
                "* Empty tree: return `true`\n" +
                "* Single node: return `true`\n" +
                "* Deep imbalance (e.g., all nodes in left subtree): return `false`\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## \uD83E\uDDD9 Tips & Considerations\n" +
                "\n" +
                "* **Avoid redundant height calls** – brute-force top-down recursion has `O(n^2)` time.\n" +
                "* Think **post-order**: always process children before root.\n" +
                "* Early return (`-1`) helps cut off recursion as soon as an imbalance is found.\n" +
                "* Understand recursive depth limits in Java if input trees are very large.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## \uD83E\uDDE9 Variants to Practice\n" +
                "\n" +
                "* ✅ [Check if tree is symmetric](https://leetcode.com/problems/symmetric-tree/)\n" +
                "* ✅ \\[Check if tree is height-balanced and complete]\n" +
                "* \uD83D\uDD01 \\[Find height of a binary tree]\n" +
                "\n" +
                "```\n" +
                "\n" +
                "Would you like this saved as a downloadable `.md` or PDF file?\n" +
                "```\n");
    }
}