package solutions.p145;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class SolutionStack {


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;
        TreeNode lastVisited = null;

        while (current != null || !stack.isEmpty()) {

            // Step 1: go as left as possible
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Step 2: look at the node on top
            TreeNode peekNode = stack.peek();

            // Step 3: if right child exists and hasn't been processed
            if (peekNode.right != null && lastVisited != peekNode.right) {
                current = peekNode.right;
            } else {
                // Step 4: visit node
                result.add(peekNode.val);
                lastVisited = stack.pop();
            }
        }

        return result;
    }
}
