package solutions.p226;

import common.TreeNode;
import markdown.MarkdownUtils;

public class Solution {

    public TreeNode invertTree(TreeNode root) {

        return invert_tree_helper(root);
    }

    private TreeNode invert_tree_helper(TreeNode node) {

        if (node == null) return null;

        TreeNode temporary_node = node.left;
        node.left = node.right;
        node.right = temporary_node;

        invert_tree_helper(node.left);
        invert_tree_helper(node.right);

        return node;
    }

    public static void main(String[] args) {

        MarkdownUtils.printMarkdownToConsole("Here's a comprehensive breakdown of LeetCode Problem 226: **Invert Binary Tree**, covering intuition, implementation tips, and complexity analysis.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## \uD83E\uDDE0 Intuition\n" +
                "\n" +
                "The goal is to **invert** or **mirror** a binary tree, meaning for every node, swap its left and right children. This operation should be applied recursively to all nodes of the tree, effectively flipping the structure of the entire tree.([algo.monster][1])\n" +
                "\n" +
                "This is a classic **tree traversal** problem, and **Depth-First Search (DFS)** is a natural fit. By visiting each node and swapping its children, we can recursively invert the entire tree. ([algo.monster][1])\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## \uD83D\uDEE0\uFE0F Implementation Tips\n" +
                "\n" +
                "* **Recursive Approach**:\n" +
                "\n" +
                "  * **Base Case**: If the current node is `null`, return `null`.\n" +
                "  * **Swap**: Exchange the left and right children of the current node.\n" +
                "  * **Recursive Calls**: Recursively invert the left and right subtrees.\n" +
                "  * **Return**: Return the current node after its subtrees have been inverted.([linkedin.com][2], [algo.monster][1])\n" +
                "\n" +
                "  **Example in Java**:\n" +
                "\n" +
                "```java\n" +
                "  public TreeNode invertTree(TreeNode root) {\n" +
                "      if (root == null) return null;\n" +
                "      TreeNode temp = root.left;\n" +
                "      root.left = invertTree(root.right);\n" +
                "      root.right = invertTree(temp);\n" +
                "      return root;\n" +
                "  }\n" +
                "```\n" +
                "\n" +
                "\n" +
                "\n" +
                "* **Iterative Approach (Using BFS)**:\n" +
                "\n" +
                "  * Use a queue to perform level-order traversal.\n" +
                "  * For each node, swap its left and right children.\n" +
                "  * Enqueue the non-null children to continue the process.([medium.com][3], [palashsharma891.medium.com][4])\n" +
                "\n" +
                "  **Example in Java**:\n" +
                "\n" +
                "```java\n" +
                "  public TreeNode invertTree(TreeNode root) {\n" +
                "      if (root == null) return null;\n" +
                "      Queue<TreeNode> queue = new LinkedList<>();\n" +
                "      queue.add(root);\n" +
                "      while (!queue.isEmpty()) {\n" +
                "          TreeNode current = queue.poll();\n" +
                "          TreeNode temp = current.left;\n" +
                "          current.left = current.right;\n" +
                "          current.right = temp;\n" +
                "          if (current.left != null) queue.add(current.left);\n" +
                "          if (current.right != null) queue.add(current.right);\n" +
                "      }\n" +
                "      return root;\n" +
                "  }\n" +
                "```\n" +
                "\n" +
                "\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## ⏱\uFE0F Time and Space Complexity\n" +
                "\n" +
                "* **Time Complexity**: `O(n)`\n" +
                "\n" +
                "  * Each node is visited exactly once, where `n` is the number of nodes in the tree.([stackoverflow.com][5], [algo.monster][1])\n" +
                "\n" +
                "* **Space Complexity**:\n" +
                "\n" +
                "  * **Recursive Approach**: `O(h)`\n" +
                "\n" +
                "    * `h` is the height of the tree. In the worst case (skewed tree), this becomes `O(n)`.\n" +
                "  * **Iterative Approach**: `O(n)`\n" +
                "\n" +
                "    * In the worst case, the queue may hold up to `n/2` nodes (at the bottom level of a full binary tree).\n" +
                "\n" +
                "These complexities ensure that the algorithm is efficient for large trees. ([algo.monster][1], [dev.to][6])\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## \uD83D\uDCDD Summary\n" +
                "\n" +
                "* **Problem**: Invert a binary tree by swapping left and right children recursively.\n" +
                "* **Approach**: Use DFS (recursive) or BFS (iterative) to traverse and invert the tree.\n" +
                "* **Time Complexity**: `O(n)`\n" +
                "* **Space Complexity**: `O(h)` for recursive, `O(n)` for iterative.([algo.monster][1], [medium.com][3], [reddit.com][7])\n" +
                "\n" +
                "This problem is a fundamental exercise in understanding tree traversals and recursion, making it a staple in technical interviews.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "[1]: https://algo.monster/liteproblems/226?utm_source=chatgpt.com \"226. Invert Binary Tree - In-Depth Explanation\"\n" +
                "[2]: https://www.linkedin.com/pulse/grind-75-6-invert-binary-tree-senthil-e?utm_source=chatgpt.com \"Grind 75 - 6 - Invert Binary Tree - LinkedIn\"\n" +
                "[3]: https://medium.com/%40armanabkar/inverting-binary-tree-in-javascript-f57f7a276a77?utm_source=chatgpt.com \"Inverting Binary Tree in JavaScript | by Arman - Medium\"\n" +
                "[4]: https://palashsharma891.medium.com/226-invert-binary-tree-leetcode-python-216edc07fc19?utm_source=chatgpt.com \"226. Invert Binary Tree — LeetCode(Python) | by Palash Sharma\"\n" +
                "[5]: https://stackoverflow.com/questions/67989896/space-complexity-of-invert-a-binary-tree?utm_source=chatgpt.com \"Space Complexity of Invert a Binary Tree - Stack Overflow\"\n" +
                "[6]: https://dev.to/samuelhinchliffe/226-invert-binary-tree-117j?utm_source=chatgpt.com \"226. Invert Binary Tree - DEV Community\"\n" +
                "[7]: https://www.reddit.com/r/leetcode/comments/15xh346/help_with_leetcode_226_invert_a_binary_tree/?utm_source=chatgpt.com \"Help with Leetcode 226 - Invert a Binary Tree - Reddit\"\n" +
                "Yes, **absolutely** — **BFS (Breadth-First Search)** **can** be used to solve the *Invert Binary Tree* problem, and it’s a perfectly valid alternative to the recursive DFS solution.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## \uD83D\uDD04 How BFS Works for Inversion\n" +
                "\n" +
                "Instead of recursing down each branch, you **traverse level-by-level**, using a **queue**, and **swap the left and right children** of each node as you visit it.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## ✅ BFS Example (Java)\n" +
                "\n" +
                "```java\n" +
                "public TreeNode invertTree(TreeNode root) {\n" +
                "    if (root == null) return null;\n" +
                "\n" +
                "    Queue<TreeNode> queue = new LinkedList<>();\n" +
                "    queue.add(root);\n" +
                "\n" +
                "    while (!queue.isEmpty()) {\n" +
                "        TreeNode current = queue.poll();\n" +
                "\n" +
                "        // Swap the children\n" +
                "        TreeNode temp = current.left;\n" +
                "        current.left = current.right;\n" +
                "        current.right = temp;\n" +
                "\n" +
                "        // Add children to queue if they exist\n" +
                "        if (current.left != null) queue.add(current.left);\n" +
                "        if (current.right != null) queue.add(current.right);\n" +
                "    }\n" +
                "\n" +
                "    return root;\n" +
                "}\n" +
                "```\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## \uD83D\uDD0D When to Use BFS over DFS\n" +
                "\n" +
                "| Case                                                   | Prefer BFS?              |\n" +
                "| ------------------------------------------------------ | ------------------------ |\n" +
                "| Avoiding deep recursion (stack overflow in deep trees) | ✅ Yes                    |\n" +
                "| You want to invert level-by-level for visualization    | ✅ Yes                    |\n" +
                "| Memory efficiency for shallow trees                    | ❌ Not necessarily better |\n" +
                "\n" +
                "---\n" +
                "\n" +
                "## ⏱ Complexity (BFS)\n" +
                "\n" +
                "* **Time Complexity**: `O(n)` — every node is visited once.\n" +
                "* **Space Complexity**: `O(n)` — queue may hold up to half the nodes in a full binary tree (worst case: all leaf nodes).\n" +
                "\n" +
                "---\n" +
                "\n" +
                "### ✅ TL;DR\n" +
                "\n" +
                "Yes, **BFS works great** for inverting a binary tree — just use a queue and swap children at each level. It’s iterative, avoids recursion stack overflow, and is often easier to debug in real-world systems.\n" +
                "\n" +
                "Let me know if you want a Python version or a visual step-by-step animation of the BFS inversion.\n");
    }
}
