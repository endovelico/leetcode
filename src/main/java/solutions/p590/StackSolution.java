package solutions.p590;

import common.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class StackSolution {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            Node current_node = stack.pop();
            result.add(current_node.val);

            // push children in normal order
            for (Node child : current_node.children) {
                stack.push(child);
            }
        }

        Collections.reverse(result);
        return result;
    }
}
