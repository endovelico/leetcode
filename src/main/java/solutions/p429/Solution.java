package solutions.p429;

import common.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Solution {
    public List<List<Integer>> levelOrder(Node root) {

        // This will hold the final result:
        // each inner list = one level of the tree
        List<List<Integer>> result = new ArrayList<>();

        // Edge case: empty tree
        if (root == null) return result;

        // Queue is used for BFS (level-order traversal)
        Queue<Node> queue = new LinkedList<>();

        // Start BFS from the root
        queue.offer(root);

        // Continue until there are no more nodes to process
        while (!queue.isEmpty()) {

            // IMPORTANT:
            // queue.size() right now = number of nodes in THIS level
            int size = queue.size();

            // List to store all values from the current level
            List<Integer> level = new ArrayList<>();

            // Process exactly 'size' nodes (one full level)
            for (int i = 0; i < size; i++) {

                // Remove the next node from the queue
                Node node = queue.poll();

                // Add its value to the current level
                level.add(node.val);

                // Add all children to the queue
                // (they belong to the NEXT level)
                for (Node child : node.children) {
                    queue.offer(child);
                }
            }

            // After processing one full level,
            // add it to the result
            result.add(level);
        }

        return result;
    }
}

